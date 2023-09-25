package io.github.youzhi.study.core.auth;

import lombok.experimental.UtilityClass;

/**
 * 用户信息 持有类
 *
 * @Author YouZhi
 * @Date 2023 - 09 - 11 - 8:48
 */
@UtilityClass
public class UserHolder {

    private static final ThreadLocal<Long> userIdTL = new ThreadLocal<>();

    public void setUserId(Long userId) {
        userIdTL.set(userId);
    }

    public Long getUserId(){
        return userIdTL.get();
    }

    public void clear(){
        userIdTL.remove();
    }

}
