package com.example.study.dto.req;

import lombok.Getter;

/**
 * 用户登录 接收DTO
 *
 * @Author YouZhi
 * @Date 2023 - 09 - 10 - 18:03
 */
@Getter
public class UserLoginReqDto {

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;
}
