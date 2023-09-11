package com.example.study.core.interceptor;

import com.example.study.core.constant.SystemConfigConsts;
import com.example.study.core.utils.JwtUtils;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * Token 解析拦截器
 *
 * @Author YouZhi
 * @Date 2023 - 09 - 10 - 20:35
 */
@Component
@RequiredArgsConstructor
public class TokenParseInterceptor implements HandlerInterceptor {

    @NonNull
    private final JwtUtils jwtUtils;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String token = request.getHeader(SystemConfigConsts.HTTP_AUH_HEADER_NAME);

        if (StringUtils.hasText(token)) {

        }

        return HandlerInterceptor.super.preHandle(request, response, handler);
    }
}
