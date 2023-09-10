package com.example.study.core.common.exception;

import com.example.study.core.common.constant.ErrorCodeEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 自定义业务异常
 *
 * @Author YouZhi
 * @Date 2023 - 09 - 10 - 18:25
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class BusinessException extends RuntimeException {

    private final ErrorCodeEnum errorCodeEnum;

    public BusinessException(ErrorCodeEnum errorCodeEnum) {
        super(errorCodeEnum.getMessage(), null, false, false);
        this.errorCodeEnum = errorCodeEnum;
    }
}
