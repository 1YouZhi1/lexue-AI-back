package com.example.study.dto.resp;

import co.elastic.clients.util.DateTime;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 评论 响应类 dto
 *
 * @Author YouZhi
 * @Date 2023 - 09 - 16 - 16:52
 */
@Data
@Builder
public class CommentsRespDto {

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

    public CommentsRespDto(Long c_id, Long post_id, String title, Long user_id, String nickName, Long likes, LocalDateTime create_time) {
        this.c_id = c_id;
        this.post_id = post_id;
        this.title = title;
        this.user_id = user_id;
        this.nickName = nickName;
        this.likes = likes;
        this.create_time = create_time;
    }
}
