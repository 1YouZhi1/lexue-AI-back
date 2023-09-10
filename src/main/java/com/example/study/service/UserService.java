package com.example.study.service;

import com.example.study.core.common.resp.RestResp;
import com.example.study.dto.req.UserLoginReqDto;
import com.example.study.dto.resp.UserLoginRespDto;

/**
 * 用户模块 服务类
 *
 * @Author YouZhi
 * @Date 2023 - 09 - 10 - 16:01
 */
public interface UserService {



    /**
     * 用户前台登录
     * @param dto
     * @return
     */
    RestResp<UserLoginRespDto> login (UserLoginReqDto dto);
}
