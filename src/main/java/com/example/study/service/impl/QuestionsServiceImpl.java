package com.example.study.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.study.core.common.resp.RestResp;
import com.example.study.core.constant.DatabaseConsts;
import com.example.study.dao.entity.Questions;
import com.example.study.dao.mapper.OptionsMapper;
import com.example.study.dao.mapper.QuestionsMapper;
import com.example.study.dto.resp.QuestionsRespDto;
import com.example.study.manager.cache.QuestionsCacheManager;
import com.example.study.service.QuestionsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 题库 实现类
 *
 * @Author YouZhi
 * @Date 2023 - 09 - 12 - 19:04
 */
@Component
@Service
@RequiredArgsConstructor
public class QuestionsServiceImpl implements QuestionsService {

    private final QuestionsMapper questionsMapper;

    private final OptionsMapper optionsMapper;

    private final QuestionsCacheManager questionsCacheManager;

    @Override
    public RestResp<List<QuestionsRespDto>> getQuestions(int num) {



        QueryWrapper<Questions> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("*")
                .orderByAsc("RAND()")
                .last(DatabaseConsts.SqlEnum.LIMIT_5.getSql());
        List<Questions> questions = questionsMapper.selectList(queryWrapper);

        for(int i = 0; i<questions.size(); i++) {

        }

        return null;
    }

    @Override
    public RestResp<List<QuestionsRespDto>> getEveryDay() {
        return RestResp.ok(questionsCacheManager.fiveQuestions());
    }


}
