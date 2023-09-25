package com.example.study.service;

import java.util.List;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.study.core.common.resp.RestResp;
import com.example.study.dto.resp.NewsInfoRespDto;
import org.springframework.web.bind.annotation.RequestParam;

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

    /**
     * 检查有没有新的新闻
     */
    void checkForNewNews();

    /**
     * 后台获取全部新闻信息
     * @param limit
     * @param page
     * @param title
     * @return
     */
    RestResp<Page<NewsInfoRespDto>> getAllNews(int limit,int page, String title);
}
