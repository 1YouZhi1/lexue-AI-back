package io.github.youzhi.study.manager.cache;

import java.util.ArrayList;
import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.github.youzhi.study.core.constant.CacheConsts;
import io.github.youzhi.study.dao.entity.ClassInfo;
import io.github.youzhi.study.dao.entity.ClassType;
import io.github.youzhi.study.dao.mapper.ClassInfoMapper;
import io.github.youzhi.study.dao.mapper.ClassTypeMapper;
import io.github.youzhi.study.dto.resp.ClassTypeInfoRespDto;
import io.github.youzhi.study.dto.resp.ClassTypeRespDto;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

/**
 * 课程列表缓存类
 *
 * @Author YouZhi
 * @Date 2023 - 09 - 19 - 9:37
 */
@Component
@RequiredArgsConstructor
public class ClassTypeCacheManager {

    private final ClassTypeMapper classTypeMapper;

    private final ClassInfoMapper classInfoMapper;

    @Cacheable(cacheManager = CacheConsts.REDIS_CACHE_MANAGER, value =CacheConsts.CLASS_TYPE_CACHE_NAME)
    public List<ClassTypeRespDto> getType(Long id) {
        List<ClassTypeRespDto> classTypeRespDtoList = new ArrayList<>();
        QueryWrapper<ClassType> queryWrapper = new QueryWrapper<>();
        if(id == 0) {
            queryWrapper.select("*")
                    .apply("father_id IS NOT NULL");;
        }else {
            queryWrapper.select("*")
                    .eq("father_id", id);
        }
        List<ClassType> classTypes = classTypeMapper.selectList(queryWrapper);

        for(ClassType classType : classTypes) {
            classTypeRespDtoList.add(ClassTypeRespDto.builder()
                    .class_name(classType.getClassName())
                    .c_id(classType.getId())
                    .build());
        }
        return classTypeRespDtoList;
    }
    @Cacheable(cacheManager = CacheConsts.REDIS_CACHE_MANAGER, value =CacheConsts.CLASS_TYPE_INFO_CACHE_NAME)
    public List<ClassTypeInfoRespDto> getTypeInfo(Long id) {
        List<ClassTypeInfoRespDto> classTypeInfoRespDto = new ArrayList<>();
        QueryWrapper<ClassInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("id, title, imgUrl")
                .eq("type_id", id);
        List<ClassInfo> classInfos = classInfoMapper.selectList(queryWrapper);
        for(ClassInfo classInfo : classInfos) {
            classTypeInfoRespDto.add(ClassTypeInfoRespDto.builder()
                    .c_id(classInfo.getId())
                    .title(classInfo.getTitle())
                    .imageUrl(classInfo.getImgUrl())
                    .build());
        }
        return classTypeInfoRespDto;
    }

}
