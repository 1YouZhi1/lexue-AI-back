package com.example.study.service;

import com.example.study.core.common.resp.RestResp;
import com.example.study.dto.req.UserLoginReqDto;
import com.example.study.dto.req.UserRegisterReqDto;
import com.example.study.dto.req.UserUpDataReqDto;
import com.example.study.dto.resp.UserInfoRespDto;
import com.example.study.dto.resp.UserLoginRespDto;
import com.example.study.dto.resp.UserRegisterRespDto;

/**
 * 用户模块 服务类
 *
 * @Author YouZhi
 * @Date 2023 - 09 - 10 - 16:01
 */
public interface UserService {

    /**
     * 用户前台注册
     * @param dto
     * @return
     */
    RestResp<UserRegisterRespDto> register (UserRegisterReqDto dto);

    /**
     * 用户前台登录
     * @param dto
     * @return
     */
    RestResp<UserLoginRespDto> login (UserLoginReqDto dto);

    /**
     * 查询用户信息
     * @param id
     * @return
     */
    RestResp<UserInfoRespDto> getUserInfo(Long id);

    /**
     * 更新用户数据
     * @param dto
     * @return
     */
    RestResp upDataUserInfo(UserUpDataReqDto dto);


}
