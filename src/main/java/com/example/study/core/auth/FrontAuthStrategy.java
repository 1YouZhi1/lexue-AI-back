package com.example.study.core.auth;

import com.example.study.core.common.exception.BusinessException;
import com.example.study.core.utils.JwtUtils;
import com.example.study.manager.cache.UserInfoCacheManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

/**
 * 前台门户系统 实现认证策略
 *
 * @Author YouZhi
 * @Date 2023 - 09 - 11 - 8:53
 */
@Component
@RequiredArgsConstructor
public class FrontAuthStrategy implements AuthStrategy{

    private final JwtUtils jwtUtils;

    private final UserInfoCacheManager userInfoCacheManager;


    @Override
    public void auth(String token, String requestUrl) throws BusinessException {
        authSSD(jwtUtils, userInfoCacheManager, token);
    }

}
