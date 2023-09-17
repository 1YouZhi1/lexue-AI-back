package com.example.study.dto.req;

import lombok.Builder;
import lombok.Data;

/**
 * 评论 请求类 dto
 *
 * @Author YouZhi
 * @Date 2023 - 09 - 17 - 20:15
 */
@Data
@Builder
public class CommentsReqDto {

    /**
     * 请求的帖子id
     */
    private Long post_id;

}
