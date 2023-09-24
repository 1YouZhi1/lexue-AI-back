package com.example.study.core.task;

import com.example.study.service.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * 新闻定时查询
 *
 * @Author YouZhi
 * @Date 2023 - 09 - 24 - 14:58
 */
@Configuration
@RequiredArgsConstructor
@EnableScheduling
public class NewsTask {

    private final NewsService newsService;

    /**
     * 每60秒检查一次有没有新的新闻
     */
    @Scheduled(fixedDelay = 60000)
    public void checkForNewNews() {
        newsService.checkForNewNews();
    }
}
