package io.github.youzhi.study.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.github.youzhi.study.core.auth.UserHolder;
import io.github.youzhi.study.core.common.resp.RestResp;
import io.github.youzhi.study.core.common.resp.TreeNode;
import io.github.youzhi.study.dao.entity.ClassInfo;
import io.github.youzhi.study.dao.entity.ClassLove;
import io.github.youzhi.study.dao.entity.ClassType;
import io.github.youzhi.study.dao.mapper.ClassInfoMapper;
import io.github.youzhi.study.dao.mapper.ClassLoveMapper;
import io.github.youzhi.study.dao.mapper.ClassTypeMapper;
import io.github.youzhi.study.dto.resp.ClassInfoRespDto;
import io.github.youzhi.study.dto.resp.ClassTypeInfoRespDto;
import io.github.youzhi.study.dto.resp.ClassTypeRespDto;
import io.github.youzhi.study.manager.cache.ClassTypeCacheManager;
import io.github.youzhi.study.service.ClassService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    private final ClassTypeMapper classTypeMapper;

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

    @Override
    public RestResp<List<ClassTypeInfoRespDto>> searchClass(String search) {
        QueryWrapper<ClassInfo> queryWrapper = new QueryWrapper<>();
        System.out.println(search);
        queryWrapper.select("id, title, imgUrl").like("title", search);
        List<ClassInfo> classInfos = classInfoMapper.selectList(queryWrapper);
        List<ClassTypeInfoRespDto> list = new ArrayList<>();
        for(ClassInfo classInfo : classInfos) {
            list.add(ClassTypeInfoRespDto.builder()
                    .c_id(classInfo.getId())
                    .title(classInfo.getTitle())
                    .imageUrl(classInfo.getImgUrl())
                    .build());
        }
        return RestResp.ok(list);
    }

    @Override
    public RestResp<List<TreeNode>> selectTree() {
        List<ClassType> classTypes = classTypeMapper.selectList(null);
        List<TreeNode> treeNodes = buildTree(classTypes);
        return RestResp.ok(treeNodes);
    }

    @Override
    public RestResp<List<ClassType>> getTypeAll() {
        List<ClassType> classTypes = classTypeMapper.selectList(null);
        return RestResp.ok(classTypes);
    }

    @Override
    public RestResp<Void> insert(ClassType classType) {
        System.out.println(classType.toString());
        classTypeMapper.insert(classType);
        return RestResp.ok();
    }

    public List<TreeNode> buildTree(List<ClassType> categories) {
        Map<Long, TreeNode> mapping = new HashMap<>();
        for (ClassType category : categories) {
            TreeNode node = new TreeNode();
            node.setId(category.getId());
            node.setLabel(category.getClassName());
            mapping.put(category.getId(), node);
        }

        List<TreeNode> roots = new ArrayList<>();
        for (ClassType category : categories) {
            TreeNode node = mapping.get(category.getId());
            if (category.getFatherId() == null) {
                roots.add(node);
            } else {
                TreeNode parentNode = mapping.get(category.getFatherId());
                if (parentNode != null) {
                    parentNode.getChildren().add(node);
                }
            }
        }
        return roots;
    }

}
