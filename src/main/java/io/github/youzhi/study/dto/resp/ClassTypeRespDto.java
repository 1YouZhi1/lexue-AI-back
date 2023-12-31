package io.github.youzhi.study.dto.resp;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * 课程类型 响应类
 *
 * @Author YouZhi
 * @Date 2023 - 09 - 18 - 15:59
 */
@Builder
@Data
public class ClassTypeRespDto implements Serializable {

    /**
     * 返回的列表c_id
     */
    private Long c_id;

    /**
     * 返回的列表名字
     */
    private String class_name;

}
