package com.example.study.service.impl;

import com.example.study.core.common.resp.RestResp;
import com.example.study.dto.req.CommentsReqDto;
import com.example.study.dto.resp.CommentsRespDto;
import com.example.study.manager.cache.CommentsCacheManager;
import com.example.study.service.CommentsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 评论 实现类
 *
 * @Author YouZhi
 * @Date 2023 - 09 - 17 - 21:06
 */
@Component
@RequiredArgsConstructor
public class CommentsServiceImpl implements CommentsService {

    private final CommentsCacheManager commentsCacheManager;

    @Override
    public RestResp<List<CommentsRespDto>> getComments(CommentsReqDto commentsReqDto) {
        return RestResp.ok(commentsCacheManager.getComments(commentsReqDto.getPost_id()));
    }
}
