package com.example.study.dto.resp;

import lombok.Builder;
import lombok.Data;

import java.util.List;
/**
 * 题库响应 dto
 *
 * @Author YouZhi
 * @Date 2023 - 09 - 12 - 16:31
 */
@Data
@Builder
public class QuestionsRespDto {

    /**
     * 题库id
     */
    private Long id;

    private Integer type;

    private List<OptionsRespDto> options;

    public QuestionsRespDto(Long id, Integer type, List<OptionsRespDto> options) {
        this.id = id;
        this.type = type;
        this.options = options;
    }
}
