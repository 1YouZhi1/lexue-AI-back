package io.github.youzhi.study.core.task;

import io.github.youzhi.study.service.QuestionsService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;


/**
 * 题目定时任务
 *
 * @Author YouZhi
 * @Date 2023 - 09 - 24 - 12:05
 */
@Slf4j
@Component
@RequiredArgsConstructor
public class QuestionTask {

    private final QuestionsService questionsService;

    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    /**
     * 使用@Scheduled注解定义定时任务，cron表达式表示每天0点触发任务
     */
    @Scheduled(cron = "0 0 0 * * ?")
    public void executeDailyTask() {
        questionsService.delEveryDat();
        questionsService.getEveryDay();
        log.info("每日0点执行:刷新每日五题");
    }
}
