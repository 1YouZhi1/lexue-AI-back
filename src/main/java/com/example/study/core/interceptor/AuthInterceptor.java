package com.example.study.core.interceptor;

import com.example.study.core.auth.AuthStrategy;
import com.example.study.core.auth.UserHolder;
import com.example.study.core.common.exception.BusinessException;
import com.example.study.core.common.resp.RestResp;
import com.example.study.core.constant.ApiRouterConsts;
import com.example.study.core.constant.SystemConfigConsts;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import java.nio.charset.StandardCharsets;
import java.util.Map;

/**
 * 用户认证拦截器
 *
 * @Author YouZhi
 * @Date 2023 - 09 - 11 - 8:40
 */
@Component
@RequiredArgsConstructor
public class AuthInterceptor implements HandlerInterceptor {

    private final Map<String, AuthStrategy> authStrategy;

    private final ObjectMapper objectMapper;

    /**
     * handle 执行前调用
     * @param request
     * @param response
     * @param handler
     * @return
     * @throws Exception
     */
    @SuppressWarnings("NullableProblems")
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //获取登录 JWT
        String token = request.getHeader(SystemConfigConsts.HTTP_AUH_HEADER_NAME);

        //获取请求的 URL
        String requestUrl = request.getRequestURI();

        // 根据请求的 URL 得到的认证策略
        String subUrl = requestUrl.substring(ApiRouterConsts.API_URL_PREFIX.length() + 1);
        String systemName = subUrl.substring(0, subUrl.indexOf("/"));
        String authStrategyName = String.format("%sAuthStrategy", systemName);

        try {
            authStrategy.get(authStrategyName).auth(token, requestUrl);
            System.out.println("yepyep");
            return HandlerInterceptor.super.preHandle(request, response, handler);
        }catch (BusinessException exception){
            //认证失败
            response.setCharacterEncoding(StandardCharsets.UTF_8.name());
            response.setContentType(MediaType.APPLICATION_JSON_VALUE);
            response.getWriter().write(
                    objectMapper.writeValueAsString(RestResp.fail(exception.getErrorCodeEnum()))
            );
            return false;
        }

    }

    /**
     * handler 执行后调用，出现异常不调用
     *
     * @param request
     * @param response
     * @param handler
     * @param modelAndView
     * @throws Exception
     */
    @SuppressWarnings("NullableProblems")
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    /**
     * DispatcherServlet 完全处理完请求后调用，出现异常照样调用
     *
     * @param request
     * @param response
     * @param handler
     * @param ex
     * @throws Exception
     */
    @SuppressWarnings("NullableProblems")
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        // 清理当前线程保存的用户数据
        UserHolder.clear();
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }

}
