package io.github.youzhi.study.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.youzhi.study.core.common.resp.RestResp;
import io.github.youzhi.study.dao.entity.UserInfo;
import io.github.youzhi.study.dto.req.UserLoginReqDto;
import io.github.youzhi.study.dto.req.UserRegisterReqDto;
import io.github.youzhi.study.dto.req.UserUpDataReqDto;
import io.github.youzhi.study.dto.resp.AdminRespDto;
import io.github.youzhi.study.dto.resp.UserInfoRespDto;
import io.github.youzhi.study.dto.resp.UserLoginRespDto;
import io.github.youzhi.study.dto.resp.UserRegisterRespDto;

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
     * 用户前台登录
     * @param dto
     * @return
     */
    RestResp<AdminRespDto> adminLogin (UserLoginReqDto dto);

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

    /**
     * 获取管理员信息
     * @return
     */
    RestResp<AdminRespDto>  getAdmin();

    /**
     * 获取全部用户信息
     * @param limit
     * @param page
     * @return
     */
    RestResp<Page<UserInfo>> getList(int limit, int page, String title);

    /**
     * 更新用户数据
     * @param userInfo
     * @return
     */
    RestResp updateUser(UserInfo userInfo);
}
