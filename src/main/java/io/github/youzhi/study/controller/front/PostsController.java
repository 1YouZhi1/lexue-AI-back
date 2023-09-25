package io.github.youzhi.study.controller.front;

import io.github.youzhi.study.core.common.resp.RestResp;
import io.github.youzhi.study.core.constant.ApiRouterConsts;
import io.github.youzhi.study.dto.req.PostsReqDto;
import io.github.youzhi.study.dto.resp.PostsInfoRespDto;
import io.github.youzhi.study.dto.resp.PostsRespDto;
import io.github.youzhi.study.service.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/many/{num}")
    public RestResp<List<PostsRespDto>> getPosts(@PathVariable int num) {
        return postsService.getPosts(num);
    }

    @GetMapping("/info/{id}")
    public RestResp<PostsInfoRespDto> getPostInfo(@PathVariable Long id) {
        return postsService.getPostInfo(id);
    }

    @PostMapping
    public RestResp insertPost(@RequestBody PostsReqDto dto) {
        return postsService.insertPost(dto);
    }
}
