package io.github.youzhi.study.service.impl;

import java.util.List;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.github.youzhi.study.core.auth.UserHolder;
import io.github.youzhi.study.core.common.constant.ErrorCodeEnum;
import io.github.youzhi.study.core.common.exception.BusinessException;
import io.github.youzhi.study.core.common.resp.RestResp;
import io.github.youzhi.study.core.constant.DatabaseConsts;
import io.github.youzhi.study.core.constant.SystemConfigConsts;
import io.github.youzhi.study.core.utils.JwtUtils;
import io.github.youzhi.study.dao.entity.UserInfo;
import io.github.youzhi.study.dao.entity.UserMsg;
import io.github.youzhi.study.dao.mapper.UserInfoMapper;
import io.github.youzhi.study.dao.mapper.UserMsgMapper;
import io.github.youzhi.study.dto.req.UserLoginReqDto;
import io.github.youzhi.study.dto.req.UserRegisterReqDto;
import io.github.youzhi.study.dto.req.UserUpDataReqDto;
import io.github.youzhi.study.dto.resp.AdminRespDto;
import io.github.youzhi.study.dto.resp.UserInfoRespDto;
import io.github.youzhi.study.dto.resp.UserLoginRespDto;
import io.github.youzhi.study.dto.resp.UserRegisterRespDto;
import io.github.youzhi.study.service.UserService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Objects;

/**
 * 用户模块 服务实现类
 *
 * @Author YouZhi
 * @Date 2023 - 09 - 10 - 16:02
 */
@Component
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    @NonNull
    private UserInfoMapper userInfoMapper;

    private final UserMsgMapper userMsgMapper;



    @NonNull
    private JwtUtils jwtUtils;

    @Override
    public RestResp<UserRegisterRespDto> register(UserRegisterReqDto dto) {

        QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(DatabaseConsts.UserInfoTable.COLUMN_USERNAME, dto.getUsername())
                .last(DatabaseConsts.SqlEnum.LIMIT_1.getSql());
        if (userInfoMapper.selectCount(queryWrapper) > 0) {
            throw new BusinessException(ErrorCodeEnum.USER_NAME_EXIST);
        }

        UserInfo userInfo = new UserInfo();
        userInfo.setUsername(dto.getUsername());
        userInfo.setPassword(DigestUtils.md5DigestAsHex(dto.getPassword().getBytes(StandardCharsets.UTF_8)));
        userInfo.setCreateTime(LocalDateTime.now());
        userInfo.setUpdateTime(LocalDateTime.now());
        userInfo.setSalt("0");
        userInfoMapper.insert(userInfo);



        return RestResp.ok(
                UserRegisterRespDto.builder()
                        .token(jwtUtils.generateToken(userInfo.getId(), SystemConfigConsts.NOVEL_FRONT_KEY))
                        .uid(userInfo.getId())
                        .build()
        );
    }

    @Override
    public RestResp<UserLoginRespDto> login(UserLoginReqDto dto) {

        QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(DatabaseConsts.UserInfoTable.COLUMN_USERNAME, dto.getUsername())
                .last(DatabaseConsts.SqlEnum.LIMIT_1.getSql());
        UserInfo userInfo = userInfoMapper.selectOne(queryWrapper);

        if (Objects.isNull(userInfo)) {
            // 用户不存在
            throw new BusinessException(ErrorCodeEnum.USER_ACCOUNT_NOT_EXIST);
        }

        // 判断密码是否正确
        if (!Objects.equals(userInfo.getPassword()
                , DigestUtils.md5DigestAsHex(dto.getPassword().getBytes(StandardCharsets.UTF_8)))) {
            // 密码错误
            throw new BusinessException(ErrorCodeEnum.USER_PASSWORD_ERROR);
        }

        return RestResp.ok(
                UserLoginRespDto.builder()
                        .uid(userInfo.getId())
                        .nickName(userInfo.getNickName())
                        .token(jwtUtils.generateToken(userInfo.getId(), SystemConfigConsts.NOVEL_FRONT_KEY))
                        .build()
        );
    }

    @Override
    public RestResp<AdminRespDto> adminLogin(UserLoginReqDto dto) {
        QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(DatabaseConsts.UserInfoTable.COLUMN_USERNAME, dto.getUsername())
                .last(DatabaseConsts.SqlEnum.LIMIT_1.getSql());
        UserInfo userInfo = userInfoMapper.selectOne(queryWrapper);
        if (Objects.isNull(userInfo)) {
            // 用户不存在
            throw new BusinessException(ErrorCodeEnum.USER_ACCOUNT_NOT_EXIST);
        }

        // 判断密码是否正确
        if (!Objects.equals(userInfo.getPassword()
                , DigestUtils.md5DigestAsHex(dto.getPassword().getBytes(StandardCharsets.UTF_8)))) {
            // 密码错误
            throw new BusinessException(ErrorCodeEnum.USER_PASSWORD_ERROR);
        }
        List<String> list = new ArrayList<>();
        list.add("admin");
        return RestResp.ok(
                AdminRespDto.builder()
                        .name(userInfo.getNickName())
                        .avatar(userInfo.getUserPhoto())
                        .introduction("halo")
                        .token(jwtUtils.generateToken(userInfo.getId(), SystemConfigConsts.NOVEL_FRONT_KEY))
                        .roles(list)
                        .build()
        );
    }


    @Override
    public RestResp<UserInfoRespDto> getUserInfo(Long id) {
        UserInfo userInfo = userInfoMapper.selectById(id);

        QueryWrapper<UserMsg> queryWrapper = new QueryWrapper<>();
        queryWrapper.select(DatabaseConsts.UserMsg.COLUMN_ID_BACK_URL)
                .eq(DatabaseConsts.UserMsg.COLUMN_UID, id)
                .last(DatabaseConsts.SqlEnum.LIMIT_1.getSql());

        return RestResp.ok(
                UserInfoRespDto.builder()
                        .nickName(userInfo.getNickName())
                        .userSex(userInfo.getUserSex())
                        .userPhoto(userInfo.getUserPhoto())
                        .backUrl(userInfo.getBackUrl())
                        .build()
        );
    }

    @Override
    public RestResp upDataUserInfo(UserUpDataReqDto dto) {
        Long userId = UserHolder.getUserId();
        UserInfo userInfo = new UserInfo();
        userInfo.setId(userId);
        userInfo.setUserPhoto(dto.getUserPhoto());
        userInfo.setNickName(dto.getNickName());
        userInfo.setUserSex(dto.getUserSex());
        userInfo.setBackUrl(dto.getBackUrl());
        userInfoMapper.updateById(userInfo);
        return RestResp.ok();
    }

    @Override
    public RestResp<AdminRespDto> getAdmin() {
        Long userId = UserHolder.getUserId();
        QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("nick_name, user_photo")
                .eq("id", 13);
        UserInfo userInfo = userInfoMapper.selectOne(queryWrapper);
        List<String> list = new ArrayList<>();
        list.add("admin");
        return RestResp.ok(AdminRespDto.builder()
                .name("管理员")
                .avatar(userInfo.getUserPhoto())
                .introduction("AI学习")
                        .roles(list)
                .build());
    }

    @Override
    public RestResp<Page<UserInfo>> getList(int limit, int page, String title) {
        // 将参数转换为整数
        int pageSize = limit;
        int pageNum = page;

        // 创建分页对象
        Page<UserInfo> pageInfo = new Page<>(pageNum, pageSize);

        // 创建查询条件
        QueryWrapper<UserInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("*");

        // 添加模糊查询条件
        if (title != null && !title.isEmpty()) {
            queryWrapper.like("nick_name", title);
        }

        // 执行分页查询
        Page<UserInfo> userPage = userInfoMapper.selectPage(pageInfo, queryWrapper);
        if (userPage.getRecords().size() < 1) {
            Page<UserInfo> nulls = new Page<>();
            return RestResp.ok(nulls);
        }


        return RestResp.ok(userPage);
    }


    @Override
    public RestResp updateUser(UserInfo userInfo) {
        userInfoMapper.updateById(userInfo);
        return RestResp.ok();
    }


}
