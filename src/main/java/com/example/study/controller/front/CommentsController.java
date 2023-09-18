package com.example.study.controller.front;

import com.example.study.core.common.resp.RestResp;
import com.example.study.core.constant.ApiRouterConsts;
import com.example.study.dao.mapper.CommentsMapper;
import com.example.study.dto.req.CommentsReqDto;
import com.example.study.dto.resp.CommentsRespDto;
import com.example.study.service.CommentsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 评论类 接口
 *
 * @Author YouZhi
 * @Date 2023 - 09 - 16 - 16:51
 */
@RestController
@RequiredArgsConstructor
@RequestMapping(ApiRouterConsts.API_FRONT_COMMENTS_URL_PREFIX)
public class CommentsController {

    private final CommentsService commentsService;

    @GetMapping
    public RestResp<List<CommentsRespDto>> getComments(Long post_id) {
        return commentsService.getComments(post_id);
    }


}
