package com.example.study.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.study.core.common.constant.ErrorCodeEnum;
import com.example.study.core.common.exception.BusinessException;
import com.example.study.core.common.resp.RestResp;
import com.example.study.core.constant.DatabaseConsts;
import com.example.study.core.constant.SystemConfigConsts;
import com.example.study.core.utils.JwtUtils;
import com.example.study.dao.entity.UserInfo;
import com.example.study.dao.mapper.UserInfoMapper;
import com.example.study.dto.req.UserLoginReqDto;
import com.example.study.dto.req.UserRegisterReqDto;
import com.example.study.dto.resp.UserLoginRespDto;
import com.example.study.dto.resp.UserRegisterRespDto;
import com.example.study.service.UserService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;
import java.time.LocalDateTime;
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

}
