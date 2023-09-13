package com.example.study.dto.resp;

import lombok.Builder;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 帖子 响应类 dto
 *
 * @Author YouZhi
 * @Date 2023 - 09 - 13 - 12:47
 */
@Data
@Builder
public class PostsRespDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 帖子id
     */
    private Long p_id;

    /**
     * 标题
     */
    private String title;

    /**
     * 图片地址
     */
    private String imageUrl;

    /**
     * 点赞数量
     */
    private Long likes;

    /**
     * 评论数
     */
    private Long comments;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;
}
