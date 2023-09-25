package io.github.youzhi.study.service;

import java.util.List;

import io.github.youzhi.study.core.common.resp.RestResp;
import io.github.youzhi.study.dto.resp.ClassInfoRespDto;
import io.github.youzhi.study.dto.resp.ClassTypeInfoRespDto;
import io.github.youzhi.study.dto.resp.ClassTypeRespDto;

/**
 * 课程 服务类
 *
 * @Author YouZhi
 * @Date 2023 - 09 - 19 - 10:27
 */
public interface ClassService {

    /**
     * 获取对应的子节目
     * @param id
     * @return
     */
    RestResp<List<ClassTypeRespDto>> getType(Long id);

    /**
     * 获取子节目中的全部内容
     * @param id
     * @return
     */
    RestResp<List<ClassTypeInfoRespDto>> getTypeInfo(Long id);

    /**
     * 获取课程详情
     * @param id
     * @return
     */
    RestResp<ClassInfoRespDto> getClassInfo(Long id);

    /**
     * 收藏课程
     * @param id
     * @return
     */
    RestResp loveClass(Long id);

    /**
     * 获取收藏的课程
     * @return
     */
    RestResp<List<ClassTypeInfoRespDto>> getLoveClass();

}
