package com.example.study.core.constant;

/**
 * 缓存类 常量
 *
 * @Author YouZhi
 * @Date 2023 - 09 - 11 - 9:21
 */
public class CacheConsts {

    /**
     * 本项目 Redis 缓存前缀
     */
    public static final String REDIS_CACHE_PREFIX = "Cache::Novel::";


    /**
     * Caffeine 缓存管理器
     */
    public static final String CAFFEINE_CACHE_MANAGER = "caffeineCacheManager";

    /**
     * Redis 缓存管理器
     */
    public static final String REDIS_CACHE_MANAGER = "redisCacheManager";

    /**
     * 用户信息缓存
     */
    public static final String USER_INFO_CACHE_NAME = "userInfoCache";

    /**
     * 课程类别
     */
    public static final String CLASS_TYPE_CACHE_NAME = "classTypeCache";

    /**
     *课程类别详情
     */
    public static final String CLASS_TYPE_INFO_CACHE_NAME = "classTypeInfoCacheName";

    /**
     * 评论信息缓存
     */
    public static final String COMMENTS_CACHE_MANAGER = "commentsCacheManager";

    /**
     * 每日五题信息缓存
     */
    public static final String QUESTIONS_INFO_CACHE_NAME = "questionsInfoCache";

    /**
     * 最新新闻缓存
     */
    public static final String LATEST_NEWS_CACHE_NAME = "latestNewsCacheName";

    /**
     * 轮播图缓存
     */
    public static final String ROTATION_INFO_CACHE_NAME = "rotationInfoCacheName";

    /**
     * 通告缓存
     */
    public static final String NOTICE_INFO_CACHE_NAME = "noticeInfoCacheName";

    /**
     * 缓存配置常量
     */
    public enum CacheEnum {

        USER_INFO_CACHE(2, USER_INFO_CACHE_NAME, 60 * 60 * 24, 10000),
        LATEST_NEWS_CACHE(2, LATEST_NEWS_CACHE_NAME, 60 * 60*24, 1000),
        QUESTIONS_INFO_FIVE_CACHE(2,QUESTIONS_INFO_CACHE_NAME, 60 * 60 *24, 1000),
        ROTATION_INFO_CACHE(2, ROTATION_INFO_CACHE_NAME, 60 * 60 *24, 1000),
        NOTICE_INFO_CACHE(2, NOTICE_INFO_CACHE_NAME, 60 * 60 *24, 100),
        COMMENTS_INFO_CACHE(2, COMMENTS_CACHE_MANAGER, 60, 10000),
        CLASS_TYPE_CACHE(2, CLASS_TYPE_CACHE_NAME, 60 * 60 * 24, 100),
        CLASS_TYPE_INFO_CACHE(2, CLASS_TYPE_INFO_CACHE_NAME, 60 * 60 *24, 100);
        /**
         * 缓存类型 0-本地 1-本地和远程 2-远程
         */
        private int type;

        /**
         * 缓存的名字
         */
        private String name;

        /**
         * 失效时间(秒) 0-永不失效
         */
        private int ttl;

        /**
         * 最大容量
         */
        private int maxSize;

        CacheEnum(int type, String name, int ttl, int maxSize) {
            this.type = type;
            this.name = name;
            this.ttl = ttl;
            this.maxSize = maxSize;
        }

        public boolean isLocal() {
            return type <= 1;
        }

        public boolean isRemote() {
            return type >= 1;
        }

        public String getName() {
            return name;
        }

        public int getTtl() {
            return ttl;
        }

        public int getMaxSize() {
            return maxSize;
        }
    }
}
