package com.example.study.service;

import com.example.study.core.common.resp.RestResp;
import com.example.study.dto.resp.QuestionsRespDto;

import java.util.List;

/**
 * 题库 service
 *
 * @Author YouZhi
 * @Date 2023 - 09 - 12 - 19:03
 */
public interface QuestionsService {

    /**
     * 获取多少题目
     * @param num
     * @return
     */
    RestResp<List<QuestionsRespDto>> getQuestions(int num);

    /**
     * 每日五道题
     * @return
     */
    RestResp<List<QuestionsRespDto>> getEveryDay();

}
