package io.github.youzhi.study.controller.front;

import io.github.youzhi.study.core.common.resp.RestResp;
import io.github.youzhi.study.core.constant.ApiRouterConsts;
import io.github.youzhi.study.dto.resp.RotationRespDto;
import io.github.youzhi.study.service.RotationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 轮播图 接口
 *
 * @Author YouZhi
 * @Date 2023 - 09 - 15 - 13:03
 */
@RestController
@RequestMapping(ApiRouterConsts.API_FRONT_ROTATION_URL_PREFIX)
@RequiredArgsConstructor
public class RotationController {

    private final RotationService rotationService;

    @GetMapping
    public RestResp<List<RotationRespDto>> getRotation() {
        return rotationService.getRotation();
    }

}
