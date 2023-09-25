package io.github.youzhi.study.manager.cache;

import io.github.youzhi.study.core.constant.CacheConsts;
import io.github.youzhi.study.dao.entity.UserInfo;
import io.github.youzhi.study.dao.mapper.UserInfoMapper;
import io.github.youzhi.study.dto.UserInfoDto;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.Objects;

/**
 * 用户信息 缓存类
 *
 * @Author YouZhi
 * @Date 2023 - 09 - 11 - 8:42
 */
@Component
@RequiredArgsConstructor
public class UserInfoCacheManager {

    private final UserInfoMapper userInfoMapper;

    @Cacheable(cacheManager = CacheConsts.REDIS_CACHE_MANAGER, value = CacheConsts.USER_INFO_CACHE_NAME)
    public UserInfoDto getUser(Long userId) {
        UserInfo userInfo = userInfoMapper.selectById(userId);
        if(Objects.isNull(userInfo)){
            return null;
        }

        return UserInfoDto.builder()
                .id(userInfo.getId())
                .status(userInfo.getStatus())
                .build();
    }

}
