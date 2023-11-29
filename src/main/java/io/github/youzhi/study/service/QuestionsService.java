package io.github.youzhi.study.service;

import io.github.youzhi.study.core.common.resp.RestResp;
import io.github.youzhi.study.dto.resp.QuestionsRespDto;

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

    /**
     * 删除每日五题缓存
     */
    void delEveryDat();

    /**
     * 获取列表
     * @return
     */
    RestResp<List<QuestionsRespDto>> getList();
}
