package com.example.study.core.constant;

/**
 * API 路由常量
 *
 * @Author YouZhi
 * @Date 2023 - 09 - 10 - 16:18
 */
public class ApiRouterConsts {

    private ApiRouterConsts() {
        throw new IllegalStateException(SystemConfigConsts.CONST_INSTANCE_EXCEPTION_MSG);
    }

    /**
     * api 请求前缀
     */
    public static final String API_URL_PREFIX = "/api";

    /**
     * 用户模块 请求前缀
     */
    public static final String USER_URL_PREFIX = "/user";

    /**
     * 前台模块 请求前缀
     */
    public static final String API_FRONT_URL_PREFIX = API_URL_PREFIX + "/front";

    /**
     * 前台用户 请求前缀
     */
    public static final String API_FRONT_USER_URL_PREFIX = API_FRONT_URL_PREFIX + USER_URL_PREFIX;

    /**
     * 资源（图片/视频/文档）模块请求路径前缀
     */
    public static final String RESOURCE_URL_PREFIX = "/resource";

    /**
     * 平台后台请求路径前缀
     */
    public static final String API_ADMIN_URL_PREFIX = API_URL_PREFIX + "/admin";

    /**
     * 付费资源
     */
    public static final String API_FRONT_BUY_URL_PREFIX = API_FRONT_URL_PREFIX + RESOURCE_URL_PREFIX;

}
