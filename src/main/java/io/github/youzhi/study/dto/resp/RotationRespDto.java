package io.github.youzhi.study.dto.resp;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * 轮播图 响应类dto
 *
 * @Author YouZhi
 * @Date 2023 - 09 - 15 - 13:04
 */
@Data
@Builder
public class RotationRespDto implements Serializable {

    /**
     * 轮播图id
     */
    private Integer r_id;

    /**
     * 新闻id
     */
    private Integer n_id;

    /**
     * 轮播图图片
     */
    private String imageUrl;

    /**
     * 轮播图标题
     */
    private String title;

    public RotationRespDto(Integer r_id, Integer n_id, String imageUrl, String title) {
        this.r_id = r_id;
        this.n_id = n_id;
        this.imageUrl = imageUrl;
        this.title = title;
    }
}
