package io.github.youzhi.study.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.github.youzhi.study.core.common.resp.RestResp;
import io.github.youzhi.study.dao.entity.Options;
import io.github.youzhi.study.dao.entity.Questions;
import io.github.youzhi.study.dao.mapper.OptionsMapper;
import io.github.youzhi.study.dao.mapper.QuestionsMapper;
import io.github.youzhi.study.dto.resp.OptionsRespDto;
import io.github.youzhi.study.dto.resp.QuestionsRespDto;
import io.github.youzhi.study.manager.cache.QuestionsCacheManager;
import io.github.youzhi.study.service.QuestionsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
                .last("limit " + num);
        List<Questions> questions = questionsMapper.selectList(queryWrapper);

        List<QuestionsRespDto> questionsRespDtoList = new ArrayList<>();
        for (Questions question : questions) {

            // 获取题目对应的选项
            QueryWrapper<Options> optionsQueryWrapper = new QueryWrapper<>();
            optionsQueryWrapper.eq("question_id", question.getQuestionId());
            List<Options> optionsList = optionsMapper.selectList(optionsQueryWrapper);

            List<OptionsRespDto> optionsRespDtoList = new ArrayList<>();
            for (Options option : optionsList) {
                OptionsRespDto optionsRespDto = new OptionsRespDto(option.getOptionId(),option.getOptionText(),option.getIsCorrect());
                optionsRespDtoList.add(optionsRespDto);
            }
            QuestionsRespDto questionsRespDto = new QuestionsRespDto(question.getQuestionId(), question.getName(),question.getType(),optionsRespDtoList);
            questionsRespDtoList.add(questionsRespDto);
        }

        return RestResp.ok(questionsRespDtoList);
    }

    @Override
    public RestResp<List<QuestionsRespDto>> getEveryDay() {
        return RestResp.ok(questionsCacheManager.fiveQuestions());
    }

    @Override
    public void delEveryDat() {
        questionsCacheManager.fiveQuestions();
    }


}
