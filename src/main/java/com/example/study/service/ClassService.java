package com.example.study.service;

import java.util.List;

import com.example.study.core.common.resp.RestResp;
import com.example.study.dto.resp.ClassTypeInfoRespDto;
import com.example.study.dto.resp.ClassTypeRespDto;

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

}
