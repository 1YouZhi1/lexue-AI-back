package io.github.youzhi.study.controller.front;

import java.util.List;

import io.github.youzhi.study.core.common.resp.RestResp;
import io.github.youzhi.study.core.constant.ApiRouterConsts;
import io.github.youzhi.study.dto.resp.QuestionsRespDto;
import io.github.youzhi.study.service.QuestionsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 题库 接口
 *
 * @Author YouZhi
 * @Date 2023 - 09 - 12 - 19:01
 */
@RestController
@RequestMapping(ApiRouterConsts.API_FRONT_QUESTIONS_URL_PREFIX)
@RequiredArgsConstructor
public class QuestionsController {

    private final QuestionsService questionsService;

    @GetMapping("{num}")
    RestResp<List<QuestionsRespDto>> getQuestions(@PathVariable("num") int num) {
        return questionsService.getQuestions(num);
    }

    @GetMapping("everyday")
    RestResp<List<QuestionsRespDto>> getEveryDay(){
        return questionsService.getEveryDay();
    }
}
