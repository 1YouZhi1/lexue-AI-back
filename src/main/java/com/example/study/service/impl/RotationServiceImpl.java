package com.example.study.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.study.core.common.resp.RestResp;
import com.example.study.dao.entity.Rotation;
import com.example.study.dao.mapper.RotationMapper;
import com.example.study.dto.resp.RotationRespDto;
import com.example.study.manager.cache.RotationCacheManager;
import com.example.study.service.RotationService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
