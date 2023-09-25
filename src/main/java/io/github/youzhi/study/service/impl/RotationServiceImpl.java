package io.github.youzhi.study.service.impl;

import io.github.youzhi.study.core.common.resp.RestResp;
import io.github.youzhi.study.dao.mapper.RotationMapper;
import io.github.youzhi.study.dto.resp.RotationRespDto;
import io.github.youzhi.study.manager.cache.RotationCacheManager;
import io.github.youzhi.study.service.RotationService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 轮播图 实现类
 *
 * @Author YouZhi
 * @Date 2023 - 09 - 15 - 13:16
 */
@RequiredArgsConstructor
@Service
public class RotationServiceImpl implements RotationService {

    private final RotationMapper rotationMapper;

    private final RotationCacheManager rotationCacheManager;

    @Override
    public RestResp<List<RotationRespDto>> getRotation() {
        return RestResp.ok(rotationCacheManager.getRotation());
    }
}
