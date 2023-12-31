package io.github.youzhi.study.core.constant;

import lombok.Getter;

/**
 * 数据库 常量
 *
 * @Author YouZhi
 * @Date 2023 - 09 - 10 - 18:09
 */
public class DatabaseConsts {

    /**
     * 用户内容表
     */
    public static class UserInfoTable{
        private UserInfoTable() {
            throw new IllegalStateException(SystemConfigConsts.CONST_INSTANCE_EXCEPTION_MSG);
        }

        public static final String COLUMN_USERNAME = "username";
    }

    /**
     * 新闻内容表
     */
    public static class NewsContentTable {

        private NewsContentTable() {
            throw new IllegalStateException(SystemConfigConsts.CONST_INSTANCE_EXCEPTION_MSG);
        }

        public static final String COLUMN_NEWS_ID = "news_id";

    }

    /**
     * 用户额外内容表
     */
    public static class UserMsg{
        private UserMsg() {
            throw new IllegalStateException(SystemConfigConsts.CONST_INSTANCE_EXCEPTION_MSG);
        }

        public static final String COLUMN_UID = "u_id";
        public static final String COLUMN_ID_BACK_URL = "id,backUrl";
    }

    /**
     * 通用列枚举类
     */
    @Getter
    public enum CommonColumnEnum {

        ID("id"),
        SORT("sort"),
        CREATE_TIME("create_time"),
        UPDATE_TIME("update_time");

        private String name;

        CommonColumnEnum(String name) {
            this.name = name;
        }

    }


    /**
     * SQL语句枚举类
     */
    @Getter
    public enum SqlEnum {

        LIMIT_1("limit 1"),
        LIMIT_2("limit 2"),
        LIMIT_5("limit 5"),
        LIMIT_10("limit 10"),
        LIMIT_30("limit 30"),
        LIMIT_500("limit 500");

        private String sql;

        SqlEnum(String sql) {
            this.sql = sql;
        }

    }

}
