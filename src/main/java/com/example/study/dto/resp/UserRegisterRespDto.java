package com.example.study.dto.resp;

import lombok.Builder;
import lombok.Data;

/**
 * 用户注册 响应类
 *
 * @Author YouZhi
 * @Date 2023 - 09 - 10 - 19:33
 */
@Data
@Builder
public class UserRegisterRespDto {

    private Long uid;

    private String token;


}
