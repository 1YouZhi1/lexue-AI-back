package com.example.study.core.auth;

import com.example.study.core.common.constant.ErrorCodeEnum;
import com.example.study.core.common.exception.BusinessException;
import com.example.study.core.constant.SystemConfigConsts;
import com.example.study.core.utils.JwtUtils;
import com.example.study.dto.UserInfoDto;
import com.example.study.manager.cache.UserInfoCacheManager;
import org.springframework.util.StringUtils;

import java.util.Objects;

/**
 * 策略模式 实现用户认证
 *
 * @Author YouZhi
 * @Date 2023 - 09 - 11 - 8:47
 */
public interface AuthStrategy {

    void auth(String token, String requestUrl) throws BusinessException;

    /**
     *
     * @param jwtUtils              jwt 工具
     * @param userInfoCacheManager  用户缓存管理对象
     * @param token                 token 登录 token
     * @return 用户ID
     */
    default Long authSSD(JwtUtils jwtUtils, UserInfoCacheManager userInfoCacheManager, String token){
        if (!StringUtils.hasText(token)){
            // token 为空
            throw new BusinessException(ErrorCodeEnum.USER_LOGIN_EXPIRED);
        }
        Long userId = jwtUtils.parseToken(token, SystemConfigConsts.NOVEL_FRONT_KEY);
        if(Objects.isNull(userId)){
            // token 解析异常
            throw new BusinessException(ErrorCodeEnum.USER_LOGIN_EXPIRED);
        }
        UserInfoDto userInfo = userInfoCacheManager.getUser(userId);
        if(Objects.isNull(userInfo)){
            //用户不存在
            throw new BusinessException(ErrorCodeEnum.USER_ACCOUNT_NOT_EXIST);
        }

        // 设置 userId 到当前线程
        UserHolder.setUserId(userId);
        //返回userId
        return userId;
    }

}
