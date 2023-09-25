package com.example.study.dto.resp;

import java.util.List;
import lombok.Builder;
import lombok.Data;

/**
 * 后台用户登录信息返回
 *
 * @Author YouZhi
 * @Date 2023 - 09 - 24 - 21:06
 */
@Data
@Builder
public class AdminRespDto {

    private String name;

    private String avatar;

    private String introduction;

    private List<String> roles;

    private String token;
}
