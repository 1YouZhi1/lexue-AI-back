package io.github.youzhi.study.controller.front;

import io.github.youzhi.study.core.auth.UserHolder;
import io.github.youzhi.study.core.common.resp.RestResp;
import io.github.youzhi.study.core.constant.ApiRouterConsts;
import io.github.youzhi.study.dto.req.UserLoginReqDto;
import io.github.youzhi.study.dto.req.UserRegisterReqDto;
import io.github.youzhi.study.dto.req.UserUpDataReqDto;
import io.github.youzhi.study.dto.resp.UserInfoRespDto;
import io.github.youzhi.study.dto.resp.UserLoginRespDto;
import io.github.youzhi.study.dto.resp.UserRegisterRespDto;
import io.github.youzhi.study.service.UserService;
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
