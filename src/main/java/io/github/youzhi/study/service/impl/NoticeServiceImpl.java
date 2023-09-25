package io.github.youzhi.study.service.impl;

import java.util.List;
import io.github.youzhi.study.core.common.resp.RestResp;
import io.github.youzhi.study.core.constant.ApiRouterConsts;
import io.github.youzhi.study.dao.entity.Notice;
import io.github.youzhi.study.manager.cache.NoticeCacheManager;
import io.github.youzhi.study.service.NoticeService;
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
