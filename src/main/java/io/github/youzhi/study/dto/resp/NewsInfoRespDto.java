package io.github.youzhi.study.dto.resp;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 新闻信息 响应DTO
 *
 * @Author YouZhi
 * @Date 2023 - 09 - 12 - 13:08
 */
@Data
@Builder
public class NewsInfoRespDto implements Serializable {

    /**
     * 新闻id
     */
    private Long id;

    /**
     * 类别id
     */
    private Long categoryId;

    /**
     * 类别名
     */
    private String categoryName;

    /**
     * 新闻来源
     */
    private String sourceName;

    /**
     * 新闻标题
     */
    private String title;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 新闻内容
     */
    private String content;

    /**
     * 新闻图片
     */
    private String image;
}
