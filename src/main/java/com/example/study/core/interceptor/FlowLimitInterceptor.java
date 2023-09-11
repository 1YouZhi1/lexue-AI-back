package com.example.study.core.interceptor;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.EntryType;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.param.ParamFlowRuleManager;
import com.example.study.core.common.constant.ErrorCodeEnum;
import com.example.study.core.common.resp.RestResp;
import com.example.study.core.common.utils.IpUtils;
import com.fasterxml.jackson.databind.ObjectMapper;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 流量限制 拦截器；实现接口防刷和限流
 *
 * @Author YouZhi
 * @Date 2023 - 09 - 10 - 20:40
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class FlowLimitInterceptor implements HandlerInterceptor {

    @NonNull
    private final ObjectMapper objectMapper;

    /**
     * 项目所有的资源
     */
    private static final String RESOURCE = "Resource";

    static {
        // 接口限流规则：所有的请求，限制每秒最多只能通过 2000 个，超出限制匀速排队
        List<FlowRule> rules = new ArrayList<>();
        FlowRule rule = new FlowRule();
        rule.setResource(RESOURCE);
        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        //set limit QPS to 2000
        rule.setCount(2000);
        rule.setControlBehavior(RuleConstant.CONTROL_BEHAVIOR_RATE_LIMITER);
        rules.add(rule);
        FlowRuleManager.loadRules(rules);

        // 接口防刷规则 1：所有的请求， 限制每个 IP 每分钟最多只能通过 50 个，超出限制直接拒绝
        ParamFlowRule rule1 = new ParamFlowRule(RESOURCE)
                .setParamIdx(0)
                .setCount(50);

        // 接口防刷规则 2: 所有的请求，限制每个 IP 每分钟最多只能通过 1000 个， 超出限制直接拒绝
        ParamFlowRule rule2 = new ParamFlowRule(RESOURCE)
                .setParamIdx(0)
                .setCount(1000)
                .setDurationInSec(60);

        ParamFlowRuleManager.loadRules(Arrays.asList(rule1, rule2));
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String ip = IpUtils.getRealIp(request);
        Entry entry = null;
        try{
            // count 大多数情况填1， 代表一次调用
            entry = SphU.entry(RESOURCE, EntryType.IN, 1, ip);
            return HandlerInterceptor.super.preHandle(request, response, handler);
        }catch (BlockException ex){
            log.info("IP: {}被限流了！", ip);
            response.setCharacterEncoding(StandardCharsets.UTF_8.name());
            response.setContentType(MediaType.APPLICATION_JSON_VALUE);
            response.getWriter()
                    .write(objectMapper.writeValueAsString(RestResp.fail(ErrorCodeEnum.USER_REQ_MANY)));
        } finally {
            // exit的时候也要带上对应参数，否则可能会有统计错误。
            if(entry != null) {
                entry.exit(1, ip);
            }
        }
        return false;
    }

}
