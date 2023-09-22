package com.example.study.dto.resp;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 评论 响应类 dto
 *
 * @Author YouZhi
 * @Date 2023 - 09 - 16 - 16:52
 */
@Data
@Builder
public class CommentsRespDto implements Serializable {

    /**
     * 评论id
     */
    private Long c_id;

    /**
     * 请求的帖子id
     */
    private Long post_id;

    /**
     * 评论的内容
     */
    private String title;

    /**
     * 发布的用户id
     */
    private Long user_id;

    /**
     * 发布用户的头像
     */
    private String imageUrl;

    /**
     * 发布的用户名
     */
    private String nickName;

    /**
     * 发布的用户评论数
     */
    private Long likes;

    /**
     * 创建时间
     */
    private LocalDateTime create_time;




}
