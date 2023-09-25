package com.example.study.controller.back;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.study.core.common.resp.RestResp;
import com.example.study.core.constant.ApiRouterConsts;
import com.example.study.dao.entity.NewsInfo;
import com.example.study.dto.resp.NewsInfoRespDto;
import com.example.study.service.NewsService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 新闻后台管理
 *
 * @Author YouZhi
 * @Date 2023 - 09 - 25 - 15:50
 */
@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(ApiRouterConsts.API_BACK_NEWS_URL_PREFIX)
public class NewsAdminController {

    private final NewsService newsService;

    @GetMapping
    public RestResp<Page<NewsInfoRespDto>> getAllNews(@RequestParam("limit") int limit, @RequestParam("page") int page, @RequestParam("title") String title){
        return newsService.getAllNews(limit, page, title);
    }

    @PutMapping
    public RestResp updateNews(@RequestBody NewsInfoRespDto newsInfoRespDto) {
        return newsService.updateNews(newsInfoRespDto);
    }

}
