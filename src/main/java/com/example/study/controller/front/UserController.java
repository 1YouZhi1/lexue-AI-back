package com.example.study.controller.front;

import com.example.study.core.auth.UserHolder;
import com.example.study.core.common.resp.RestResp;
import com.example.study.core.constant.ApiRouterConsts;
import com.example.study.dto.req.UserLoginReqDto;
import com.example.study.dto.req.UserRegisterReqDto;
import com.example.study.dto.req.UserUpDataReqDto;
import com.example.study.dto.resp.UserInfoRespDto;
import com.example.study.dto.resp.UserLoginRespDto;
import com.example.study.dto.resp.UserRegisterRespDto;
import com.example.study.service.UserService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * 前台门户-用户模块-API控制类
 *
 * @Author YouZhi
 * @Date 2023 - 09 - 10 - 16:03
 */

@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(ApiRouterConsts.API_FRONT_USER_URL_PREFIX)
public class UserController {

    @NonNull
    private UserService userService;

    @PostMapping("register")
    public RestResp<UserRegisterRespDto> register (@RequestBody UserRegisterReqDto dto) {
        return userService.register(dto);
    }

    @PostMapping("login")
    public RestResp<UserLoginRespDto> login (@RequestBody UserLoginReqDto dto) {
        return userService.login(dto);
    }

    @GetMapping
    public RestResp<UserInfoRespDto> getUserInfo(){
        return userService.getUserInfo(UserHolder.getUserId());
    }

    @PutMapping
    public RestResp upDataUserInfo(@RequestBody UserUpDataReqDto dto){
        return userService.upDataUserInfo(dto);
    }


}
