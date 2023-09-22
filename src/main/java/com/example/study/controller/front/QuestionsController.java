package com.example.study.controller.front;

import java.util.List;

import com.example.study.core.common.resp.RestResp;
import com.example.study.core.constant.ApiRouterConsts;
import com.example.study.dto.resp.QuestionsRespDto;
import com.example.study.service.QuestionsService;
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
