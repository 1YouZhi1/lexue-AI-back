package io.github.youzhi.study.core.listener;

import io.github.youzhi.study.core.constant.AmqpConsts;
import io.github.youzhi.study.dao.entity.NewsInfo;
import io.github.youzhi.study.dao.mapper.NewsInfoMapper;
import io.github.youzhi.study.manager.cache.NewsCacheManager;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * Rabbit 新闻队列监听器
 *
 * @Author YouZhi
 * @Date 2023 - 09 - 24 - 15:13
 */
@Component
@RequiredArgsConstructor
@Slf4j
public class RabbitNewsListener {

    private final NewsInfoMapper newsInfoMapper;

    private final NewsCacheManager newsCacheManager;

    @SneakyThrows
    @RabbitListener(queues = AmqpConsts.NewsMq.NEWS_REDIS_UPDATE)
    public void updateNews(NewsInfo newsInfo) {
        newsCacheManager.delLastNews();
    }


}
