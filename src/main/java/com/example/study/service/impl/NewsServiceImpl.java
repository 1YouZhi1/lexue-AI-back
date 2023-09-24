package com.example.study.service.impl;

import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.study.core.common.resp.RestResp;
import com.example.study.core.constant.AmqpConsts;
import com.example.study.core.constant.DatabaseConsts;
import com.example.study.core.constant.SystemConfigConsts;
import com.example.study.dao.entity.NewsContent;
import com.example.study.dao.entity.NewsInfo;
import com.example.study.dao.mapper.NewsContentMapper;
import com.example.study.dao.mapper.NewsInfoMapper;
import com.example.study.dto.resp.NewsInfoRespDto;
import com.example.study.manager.cache.NewsCacheManager;
import com.example.study.service.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RestController;

/**
 * 新闻模块 响应类
 *
 * @Author YouZhi
 * @Date 2023 - 09 - 12 - 12:53
 */
@Component
@RequiredArgsConstructor
public class NewsServiceImpl implements NewsService {

    private final NewsCacheManager newsCacheManager;

    private final NewsInfoMapper newsInfoMapper;

    private final NewsContentMapper newsContentMapper;

    private final RabbitTemplate rabbitTemplate;

    @Override
    public RestResp<List<NewsInfoRespDto>> listLatestNews() {
        return RestResp.ok(newsCacheManager.listLatestNews());
    }

    @Override
    public RestResp<NewsInfoRespDto> getNews(Long id) {
        NewsInfo newsInfo = newsInfoMapper.selectById(id);
        QueryWrapper<NewsContent> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq(DatabaseConsts.NewsContentTable.COLUMN_NEWS_ID, id)
                .last(DatabaseConsts.SqlEnum.LIMIT_1.getSql());
        NewsContent newsContent = newsContentMapper.selectOne(queryWrapper);
        return RestResp.ok(NewsInfoRespDto.builder()
                .title(newsInfo.getTitle())
                .sourceName(newsInfo.getSourceName())
                .updateTime(newsInfo.getUpdateTime())
                .content(newsContent.getContent())
                .build());
    }

    @Override
    public void checkForNewNews() {
        QueryWrapper<NewsInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("*")
                .orderByDesc("create_time")
                .last(DatabaseConsts.SqlEnum.LIMIT_2.getSql());
        List<NewsInfo> latestNews = newsInfoMapper.selectList(queryWrapper);
        if(!latestNews.isEmpty()) {
            for(NewsInfo newsInfo : latestNews) {
                rabbitTemplate.convertAndSend(AmqpConsts.NewsMq.NEWS_REDIS_UPDATE, newsInfo);
            }
        }
    }
}
