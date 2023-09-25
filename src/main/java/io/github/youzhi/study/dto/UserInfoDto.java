package io.github.youzhi.study.dto;

import lombok.Builder;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

/**
 * 用户信息 Dto类
 *
 * @Author YouZhi
 * @Date 2023 - 09 - 10 - 15:59
 */
@Data
@Builder
public class UserInfoDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    private Long id;

    private Integer status;

}
