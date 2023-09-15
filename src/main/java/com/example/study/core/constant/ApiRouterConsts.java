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
     * 首页新闻请求路径前缀
     */
    public static final String NEWS_URL_PREFIX = "/news";

    /**
     * 题目请求路径前缀
     */
    public static final String QUESTIONS_URL_PREFIX = "/questions";

    /**
     * 帖子请求路径前缀
     */
    public static final String POSTS_URL_PREFIX = "/posts";

    /**
     * 轮播图请求路径前缀
     */
    public static final String ROTATION_URL_PREFIX  = "/rotation";

    /**
     * 前台帖子请求路径前缀
     */
    public static final String API_FRONT_POSTS_URL_PREFIX = API_FRONT_URL_PREFIX + POSTS_URL_PREFIX;

    /**
     * 前台题目请求路径前缀
     */
    public static final String API_FRONT_QUESTIONS_URL_PREFIX = API_FRONT_URL_PREFIX + QUESTIONS_URL_PREFIX;

    /**
     * 前台轮播图请求路径前缀
     */
    public static final String API_FRONT_ROTATION_URL_PREFIX = API_FRONT_URL_PREFIX +ROTATION_URL_PREFIX;

    /**
     * 前台用户 请求前缀
     */
    public static final String API_FRONT_USER_URL_PREFIX = API_FRONT_URL_PREFIX + USER_URL_PREFIX;

    /**
     * 前台门户新闻相关API请求路径前缀
     */
    public static final String API_FRONT_NEWS_URL_PREFIX = API_FRONT_URL_PREFIX + NEWS_URL_PREFIX;

    /**
     * 资源（图片/视频/文档）模块请求路径前缀
     */
    public static final String RESOURCE_URL_PREFIX = "/resource";

    /**
     * 前台门户资源（图片/视频/文档）相关API请求路径前缀
     */
    public static final String API_FRONT_RESOURCE_URL_PREFIX = API_FRONT_URL_PREFIX + RESOURCE_URL_PREFIX;

    /**
     * 平台后台请求路径前缀
     */
    public static final String API_ADMIN_URL_PREFIX = API_URL_PREFIX + "/admin";

    /**
     * 付费资源
     */
    public static final String API_FRONT_BUY_URL_PREFIX = API_FRONT_URL_PREFIX + RESOURCE_URL_PREFIX;

}
