package com.example.study.controller.front;

import com.example.study.core.common.resp.RestResp;
import com.example.study.core.constant.ApiRouterConsts;
import com.example.study.dto.req.UserLoginReqDto;
import com.example.study.dto.resp.UserLoginRespDto;
import com.example.study.service.UserService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 前台门户-用户模块-API控制类
 *
 * @Author YouZhi
 * @Date 2023 - 09 - 10 - 16:03
 */
@RestController
@RequiredArgsConstructor
@RequestMapping(ApiRouterConsts.API_FRONT_USER_URL_PREFIX)
public class UserController {

    @NonNull
    private UserService userService;

    @PostMapping("login")
    public RestResp<UserLoginRespDto> login (@RequestBody UserLoginReqDto dto) {
        return userService.login(dto);
    }

}
