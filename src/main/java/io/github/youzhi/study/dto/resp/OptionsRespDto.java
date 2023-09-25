package io.github.youzhi.study.dto.resp;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;

/**
 * 选项响应 dto
 *
 * @Author YouZhi
 * @Date 2023 - 09 - 12 - 16:34
 */
@Data
@Builder
public class OptionsRespDto implements Serializable {

    private Long option_id;

    private String text;

    private Boolean is_correct;

    public OptionsRespDto(Long option_id, String text, Boolean is_correct) {
        this.option_id = option_id;
        this.text = text;
        this.is_correct = is_correct;
    }
}
