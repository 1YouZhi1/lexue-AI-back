package io.github.youzhi.study.service;

import java.util.List;

import io.github.youzhi.study.core.common.resp.RestResp;
import io.github.youzhi.study.dto.resp.RotationRespDto;

/**
 * 轮播图 服务类
 *
 * @Author YouZhi
 * @Date 2023 - 09 - 15 - 13:03
 */
public interface RotationService {

    /**
     * 获得轮播图
     * @return
     */
    RestResp<List<RotationRespDto>> getRotation();

}
