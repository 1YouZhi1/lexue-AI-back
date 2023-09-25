package io.github.youzhi.study.controller.front;

import io.github.youzhi.study.core.common.resp.RestResp;
import io.github.youzhi.study.core.constant.ApiRouterConsts;
import io.github.youzhi.study.dto.resp.NewsInfoRespDto;
import io.github.youzhi.study.service.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;


/**
 * 新闻接口
 *
 * @Author YouZhi
 * @Date 2023 - 09 - 12 - 13:28
 */
@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(ApiRouterConsts.API_FRONT_NEWS_URL_PREFIX)
public class NewsController {

    private final NewsService newsService;

    /**
     * 最新新闻列表查询接口
     */
    @GetMapping("latest_list")
    public RestResp<List<NewsInfoRespDto>> listLatestNews() {
        return newsService.listLatestNews();
    }

    /**
     * 新闻信息查询接口
     */
    @GetMapping("{id}")
    public RestResp<NewsInfoRespDto> getNews(@PathVariable Long id) {
        return newsService.getNews(id);
    }

}
