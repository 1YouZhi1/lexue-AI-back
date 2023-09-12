package com.example.study.service;

import java.util.List;

import com.example.study.core.common.resp.RestResp;
import com.example.study.dto.resp.NewsInfoRespDto;

/**
 * 新闻模块 服务类
 *
 * @Author YouZhi
 * @Date 2023 - 09 - 12 - 12:53
 */
public interface NewsService {

    /**
     * 查询新闻列表
     * @return
     */
    RestResp<List<NewsInfoRespDto>> listLatestNews();

    /**
     * 新闻信息查询
     *
     * @param id 新闻ID
     * @return 新闻信息
     */
    RestResp<NewsInfoRespDto> getNews(Long id);
}
