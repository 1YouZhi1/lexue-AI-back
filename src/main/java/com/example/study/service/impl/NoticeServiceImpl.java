package com.example.study.service.impl;

import java.util.List;
import com.example.study.core.common.resp.RestResp;
import com.example.study.core.constant.ApiRouterConsts;
import com.example.study.dao.entity.Notice;
import com.example.study.manager.cache.NoticeCacheManager;
import com.example.study.service.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 通告实现类
 *
 * @Author YouZhi
 * @Date 2023 - 09 - 15 - 14:24
 */
@Component
@RequiredArgsConstructor
@RequestMapping(ApiRouterConsts.API_NOTICE_URL_PREFIX)
public class NoticeServiceImpl implements NoticeService {

    private final NoticeCacheManager noticeCacheManager;

    @Override
    public RestResp<List<Notice>> getNotice() {
        return RestResp.ok(noticeCacheManager.getNotice());
    }
}
