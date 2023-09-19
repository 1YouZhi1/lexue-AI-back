package com.example.study.service.impl;

import com.example.study.core.common.resp.RestResp;
import com.example.study.dto.resp.ClassTypeInfoRespDto;
import com.example.study.dto.resp.ClassTypeRespDto;
import com.example.study.manager.cache.ClassTypeCacheManager;
import com.example.study.service.ClassService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 课程 实现类
 *
 * @Author YouZhi
 * @Date 2023 - 09 - 19 - 10:30
 */
@Component
@RequiredArgsConstructor
public class ClassServiceImpl implements ClassService {

    private final ClassTypeCacheManager classTypeCacheManager;

    @Override
    public RestResp<List<ClassTypeRespDto>> getType(Long id) {
        return RestResp.ok(classTypeCacheManager.getType(id));
    }

    @Override
    public RestResp<List<ClassTypeInfoRespDto>> getTypeInfo(Long id) {
        return RestResp.ok(classTypeCacheManager.getTypeInfo(id));
    }


}
