package com.example.study.service;

import java.util.List;
import com.example.study.core.common.resp.RestResp;
import com.example.study.dto.req.CommentsReqDto;
import com.example.study.dto.resp.CommentsRespDto;

/**
 * 评论 服务类
 *
 * @Author YouZhi
 * @Date 2023 - 09 - 17 - 20:41
 */
public interface CommentsService {

    /**
     * 获取评论
     * @param post_id
     * @return
     */
    RestResp<List<CommentsRespDto>> getComments(Long post_id);

    /**
     * 新增评论
     * @param commentsReqDto
     * @return
     */
    RestResp insertComments(CommentsReqDto commentsReqDto);

}
