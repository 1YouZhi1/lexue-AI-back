package com.example.study.core.config;

import com.example.study.core.constant.ApiRouterConsts;
import com.example.study.core.constant.SystemConfigConsts;
import com.example.study.core.interceptor.AuthInterceptor;
import com.example.study.core.interceptor.FileInterceptor;
import com.example.study.core.interceptor.FlowLimitInterceptor;
import com.example.study.core.interceptor.TokenParseInterceptor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 拦截器配置
 *
 * @Author YouZhi
 * @Date 2023 - 09 - 11 - 8:55
 */
@Component
@RequiredArgsConstructor
public class WebConfig implements WebMvcConfigurer {

    private final FlowLimitInterceptor flowLimitInterceptor;

    private final AuthInterceptor authInterceptor;

    private final FileInterceptor fileInterceptor;

    private final TokenParseInterceptor tokenParseInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(flowLimitInterceptor)
                .addPathPatterns("/**")
                .order(0);

        registry.addInterceptor(fileInterceptor)
                .addPathPatterns(SystemConfigConsts.IMAGE_UPLOAD_DIRECTORY + "**",
                        SystemConfigConsts.VIDEO_UPLOAD_DIRECTORY + "**")
                .order(1);

        registry.addInterceptor(authInterceptor)
                //拦截前台用户相关请求接口
                .addPathPatterns(ApiRouterConsts.API_FRONT_URL_PREFIX + "/**",
                        ApiRouterConsts.API_ADMIN_URL_PREFIX + "/**")
                .excludePathPatterns(ApiRouterConsts.API_FRONT_USER_URL_PREFIX + "/register",
                        ApiRouterConsts.API_FRONT_USER_URL_PREFIX + "/login",
                        ApiRouterConsts.API_ADMIN_URL_PREFIX + "/login",
                        ApiRouterConsts.API_FRONT_POSTS_URL_PREFIX + "/many/*",
                        ApiRouterConsts.API_NOTICE_URL_PREFIX,
                        ApiRouterConsts.API_FRONT_ROTATION_URL_PREFIX)
                .order(2);

        registry.addInterceptor(tokenParseInterceptor)
                .addPathPatterns(ApiRouterConsts.API_FRONT_BUY_URL_PREFIX + "/content/*")
                .order(3);

    }


}
