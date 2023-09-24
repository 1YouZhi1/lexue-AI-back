package com.example.study.dto.resp;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * 课程详情 页面
 *
 * @Author YouZhi
 * @Date 2023 - 09 - 19 - 16:23
 */
@Data
@Builder
public class ClassInfoRespDto {

    /**
     * 课程id
     */
    private Long id;

    /**
     * 课程标题
     */
    private String title;

    /**
     * 课程视频url
     */
    private String video_url;

    /**
     * 课程介绍
     */
    private String content;

    /**
     * 创建时间
     */
    private LocalDateTime create_time;

    /**
     * 是否收藏
     */
    private Boolean like;
}
