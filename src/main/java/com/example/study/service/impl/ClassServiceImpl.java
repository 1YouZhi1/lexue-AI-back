package com.example.study.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.study.core.common.resp.RestResp;
import com.example.study.dao.entity.ClassInfo;
import com.example.study.dao.mapper.ClassInfoMapper;
import com.example.study.dto.resp.ClassInfoRespDto;
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

    private final ClassInfoMapper classInfoMapper;

    @Override
    public RestResp<List<ClassTypeRespDto>> getType(Long id) {
        return RestResp.ok(classTypeCacheManager.getType(id));
    }

    @Override
    public RestResp<List<ClassTypeInfoRespDto>> getTypeInfo(Long id) {
        return RestResp.ok(classTypeCacheManager.getTypeInfo(id));
    }

    @Override
    public RestResp<ClassInfoRespDto> getClassInfo(Long id) {
        QueryWrapper<ClassInfo> queryWrapper = new QueryWrapper<ClassInfo>();
        queryWrapper.select("title, video_url, content, create_time, video_url")
                .eq("id", id);
        ClassInfo classInfo = classInfoMapper.selectOne(queryWrapper);
        return RestResp.ok(ClassInfoRespDto.builder()
                .id(classInfo.getId())
                .title(classInfo.getTitle())
                .content(classInfo.getContent())
                .create_time(classInfo.getCreateTime())
                .video_url(classInfo.getVideoUrl())
                .build());
    }


}
