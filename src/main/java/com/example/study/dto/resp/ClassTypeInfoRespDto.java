package com.example.study.dto.resp;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * 课程类型 课 响应类 dto
 *
 * @Author YouZhi
 * @Date 2023 - 09 - 19 - 12:19
 */
@Data
@Builder
public class ClassTypeInfoRespDto implements Serializable {

    /**
     * 课程id
     */
    private Long c_id;

    /**
     * 课程标题
     */
    private String title;

    /**
     * 课程图片
     */
    private String imageUrl;
}
