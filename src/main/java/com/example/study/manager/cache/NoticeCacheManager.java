package com.example.study.manager.cache;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.study.core.common.resp.RestResp;
import com.example.study.core.constant.CacheConsts;
import com.example.study.dao.entity.Notice;
import com.example.study.dao.mapper.NoticeMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 通告 缓存类
 *
 * @Author YouZhi
 * @Date 2023 - 09 - 15 - 15:02
 */
@Component
@RequiredArgsConstructor
public class NoticeCacheManager {

    private final NoticeMapper noticeMapper;

    @Cacheable(cacheManager = CacheConsts.REDIS_CACHE_MANAGER, value = CacheConsts.NOTICE_INFO_CACHE_NAME)
    public List<Notice> getNotice() {
        QueryWrapper<Notice> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("*");

        List<Notice> notices = noticeMapper.selectList(queryWrapper);
        System.out.println(notices);
        return notices;
    }

}
