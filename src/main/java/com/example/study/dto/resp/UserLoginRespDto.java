package com.example.study.dto.resp;

import lombok.Builder;
import lombok.Data;

/**
 * 用户登录 返回dto
 *
 * @Author YouZhi
 * @Date 2023 - 09 - 10 - 17:00
 */
@Data
@Builder
public class UserLoginRespDto {

    private Long uid;

    private String nickName;

    private String token;

}
