package com.example.study.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.study.core.auth.UserHolder;
import com.example.study.core.common.resp.RestResp;
import com.example.study.dao.entity.ClassInfo;
import com.example.study.dao.entity.ClassLove;
import com.example.study.dao.mapper.ClassInfoMapper;
import com.example.study.dao.mapper.ClassLoveMapper;
import com.example.study.dto.resp.ClassInfoRespDto;
import com.example.study.dto.resp.ClassTypeInfoRespDto;
import com.example.study.dto.resp.ClassTypeRespDto;
import com.example.study.manager.cache.ClassTypeCacheManager;
import com.example.study.service.ClassService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
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

    private final ClassLoveMapper classLoveMapper;

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
        Boolean likes = null;
        QueryWrapper<ClassInfo> queryWrapper = new QueryWrapper<ClassInfo>();
        queryWrapper.select("title, video_url, content, create_time, video_url")
                .eq("id", id);
        ClassInfo classInfo = classInfoMapper.selectOne(queryWrapper);
        QueryWrapper<ClassLove> queryWrapper1 = new QueryWrapper<>();
        queryWrapper1.select("*")
                .eq("c_id", id);
        if (classLoveMapper.selectCount(queryWrapper1) < 1) {
            likes = false;
        }else {
            likes = true;
        }


        return RestResp.ok(ClassInfoRespDto.builder()
                .id(classInfo.getId())
                .title(classInfo.getTitle())
                .content(classInfo.getContent())
                .create_time(classInfo.getCreateTime())
                .video_url(classInfo.getVideoUrl())
                .like(likes)
                .build());
    }

    @Override
    public RestResp loveClass(Long id) {
        Long userId = UserHolder.getUserId();
        classLoveMapper.insert(new ClassLove(id,userId));
        return RestResp.ok();
    }

    @Override
    public RestResp<List<ClassTypeInfoRespDto>> getLoveClass() {
        List<ClassTypeInfoRespDto> classTypeInfoRespDto = new ArrayList<>();
        Long userId = UserHolder.getUserId();
        QueryWrapper<ClassLove> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("c_id")
                .eq("u_id",userId);
        List<Long> longs = classLoveMapper.selectList(queryWrapper).stream().map(v -> v.getcId()).toList();

        List<ClassInfo> classInfos = new ArrayList<>();
        for(Long l : longs){
            QueryWrapper<ClassInfo> queryWrapper1 = new QueryWrapper<>();
            queryWrapper1.select("*")
                    .eq("id", l);
            ClassInfo classInfo = classInfoMapper.selectOne(queryWrapper1);
            classInfos.add(classInfo);
        }

        for(ClassInfo classInfo : classInfos) {
            classTypeInfoRespDto.add(ClassTypeInfoRespDto.builder()
                    .c_id(classInfo.getId())
                    .title(classInfo.getTitle())
                    .imageUrl(classInfo.getImgUrl())
                    .build());
        }
        return RestResp.ok(classTypeInfoRespDto);
    }


}
