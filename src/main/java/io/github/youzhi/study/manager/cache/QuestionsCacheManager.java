package io.github.youzhi.study.manager.cache;

import java.util.ArrayList;
import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import io.github.youzhi.study.core.constant.CacheConsts;
import io.github.youzhi.study.core.constant.DatabaseConsts;
import io.github.youzhi.study.dao.entity.Options;
import io.github.youzhi.study.dao.entity.Questions;
import io.github.youzhi.study.dao.mapper.OptionsMapper;
import io.github.youzhi.study.dao.mapper.QuestionsMapper;
import io.github.youzhi.study.dto.resp.OptionsRespDto;
import io.github.youzhi.study.dto.resp.QuestionsRespDto;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

/**
 * 题目 缓存类
 *
 * @Author YouZhi
 * @Date 2023 - 09 - 12 - 19:18
 */
@Component
@RequiredArgsConstructor
public class QuestionsCacheManager {

    private final QuestionsMapper questionsMapper;

    private final OptionsMapper optionsMapper;

    /**
     * 获取五个题目,并放入缓存中
     * @return
     */
    @Cacheable(cacheManager = CacheConsts.REDIS_CACHE_MANAGER, value = CacheConsts.QUESTIONS_INFO_CACHE_NAME)
    public List<QuestionsRespDto> fiveQuestions() {
        QueryWrapper<Questions> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("*")
               .orderByAsc("RAND()")
               .last(DatabaseConsts.SqlEnum.LIMIT_5.getSql());

        // 获取随机的五个题目
        List<Questions> randomQuestions = questionsMapper.selectList(queryWrapper);

        List<QuestionsRespDto> questionsRespDtoList = new ArrayList<>();

        for (Questions question : randomQuestions) {

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

        System.out.println(questionsRespDtoList);
        return questionsRespDtoList;
    }

    @CacheEvict(cacheManager = CacheConsts.REDIS_CACHE_MANAGER, value = CacheConsts.QUESTIONS_INFO_CACHE_NAME)
    public void delEveryDay() {

    }
}
