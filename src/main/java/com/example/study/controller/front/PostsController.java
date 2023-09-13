package com.example.study.controller.front;

import com.example.study.core.common.resp.RestResp;
import com.example.study.core.constant.ApiRouterConsts;
import com.example.study.dto.resp.PostsInfoRespDto;
import com.example.study.dto.resp.PostsRespDto;
import com.example.study.service.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 帖子 接口类
 *
 * @Author YouZhi
 * @Date 2023 - 09 - 13 - 13:36
 */
@RestController
@RequestMapping(ApiRouterConsts.API_FRONT_POSTS_URL_PREFIX)
@RequiredArgsConstructor
public class PostsController {

    private final PostsService postsService;

    @GetMapping("{num}")
    public RestResp<List<PostsRespDto>> getPosts(@PathVariable int num) {
        return postsService.getPosts(num);
    }

    @GetMapping("/info/{id}")
    public RestResp<PostsInfoRespDto> getPostInfo(@PathVariable Long id) {
        return postsService.getPostInfo(id);
    }

}
