package io.github.youzhi.study.controller.back;

import io.github.youzhi.study.core.common.resp.RestResp;
import io.github.youzhi.study.core.constant.ApiRouterConsts;
import io.github.youzhi.study.dto.resp.QuestionsRespDto;
import io.github.youzhi.study.service.QuestionsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Author YouZhi
 * @Date 2023 - 11 - 27 - 15:45
 */
@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(ApiRouterConsts.API_BACK_QUESTIONS_URL_PREFIX)
public class QuestionsAdminController {

    private final QuestionsService questionsService;

    @GetMapping("/getList")
    public RestResp<List<QuestionsRespDto>> getList(){
        return questionsService.getList();
    }

}
