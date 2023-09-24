package com.example.study.manager.cache;

import java.util.List;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.study.core.constant.CacheConsts;
import com.example.study.core.constant.DatabaseConsts;
import com.example.study.dao.entity.NewsInfo;
import com.example.study.dao.mapper.NewsInfoMapper;
import com.example.study.dto.resp.NewsInfoRespDto;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

/**
 * 新闻 缓存类
 *
 * @Author YouZhi
 * @Date 2023 - 09 - 12 - 13:23
 */
@Component
@RequiredArgsConstructor
public class NewsCacheManager {

    private final NewsInfoMapper newsInfoMapper;

    /**
     * 最新新闻列表查询，并放入缓存中
     */
    @Cacheable(cacheManager = CacheConsts.REDIS_CACHE_MANAGER, value = CacheConsts.LATEST_NEWS_CACHE_NAME)
    public List<NewsInfoRespDto> listLatestNews() {
        // 从新闻信息表中查询出最新发布的两条新闻
        QueryWrapper<NewsInfo> queryWrapper = new QueryWrapper<>();
        queryWrapper.orderByDesc(DatabaseConsts.CommonColumnEnum.CREATE_TIME.getName())
                .last(DatabaseConsts.SqlEnum.LIMIT_10.getSql());
        return newsInfoMapper.selectList(queryWrapper).stream().map(v -> NewsInfoRespDto.builder()
                .id(v.getId())
                .categoryId(v.getCategoryId())
                .categoryName(v.getCategoryName())
                .title(v.getTitle())
                .sourceName(v.getSourceName())
                .updateTime(v.getUpdateTime())
                .image(v.getCategoryImage())
                .build()).toList();
    }

    /**
     * 删除缓存
     */
    @CacheEvict(cacheManager = CacheConsts.REDIS_CACHE_MANAGER, value = CacheConsts.LATEST_NEWS_CACHE_NAME)
    public void delLastNews() {

    }
}
