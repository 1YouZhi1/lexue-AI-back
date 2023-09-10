package com.example.study.core.constant;

/**
 * 系统配置相关常量
 *
 * @Author YouZhi
 * @Date 2023 - 09 - 10 - 16:24
 */
public class SystemConfigConsts {

    private SystemConfigConsts() {
        throw new IllegalStateException(CONST_INSTANCE_EXCEPTION_MSG);
    }

    /**
     * Http 请求认证 Header
     */
    public static final String HTTP_AUH_HEADER_NAME = "Authorization";

    /**
     * 前台门户系统标识
     */
    public static final String NOVEL_FRONT_KEY = "front";

    /**
     * 常量类实例化
     */
    public static final String CONST_INSTANCE_EXCEPTION_MSG = "Constant class";



}
