package com.example.study.dto.req;

import lombok.Builder;
import lombok.Data;

import java.util.List;
/**
 * 帖子上传 dto
 *
 * @Author YouZhi
 * @Date 2023 - 09 - 18 - 14:17
 */
@Data
@Builder
public class PostsReqDto {

    /**
     * 帖子id
     */
    private Long post_id;

    /**
     * 帖子标题
     */
    private String title;

    /**
     * 帖子内容
     */
    private String content;

    /**
     * 帖子图片路径
     */
    private List<String> imageUrl;

}
