package io.github.youzhi.study.manager.cache;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.github.youzhi.study.core.constant.CacheConsts;
import io.github.youzhi.study.dao.entity.Rotation;
import io.github.youzhi.study.dao.mapper.RotationMapper;
import io.github.youzhi.study.dto.resp.RotationRespDto;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * 轮播图 缓存类
 *
 * @Author YouZhi
 * @Date 2023 - 09 - 15 - 13:19
 */
@Component
@RequiredArgsConstructor
public class RotationCacheManager {

    private final RotationMapper rotationMapper;

    @Cacheable(cacheManager = CacheConsts.REDIS_CACHE_MANAGER, value = CacheConsts.ROTATION_INFO_CACHE_NAME)
    public List<RotationRespDto> getRotation() {
        QueryWrapper<Rotation> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("*")
                .eq("is_show", true)
                .orderByAsc("sort");
        List<Rotation> rotations = rotationMapper.selectList(queryWrapper);
        List<RotationRespDto> rotationRespDto = new ArrayList<>();
        for(Rotation rotation: rotations) {
            RotationRespDto rotationRespDto1 = new RotationRespDto(rotation.getId(),rotation.getNewsId(),rotation.getAdvImage(),rotation.getAdvTitle());
            rotationRespDto.add(rotationRespDto1);
        }
        return rotationRespDto;
    }

}
