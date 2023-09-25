package io.github.youzhi.study.service.impl;

import io.github.youzhi.study.core.auth.UserHolder;
import io.github.youzhi.study.core.common.constant.ErrorCodeEnum;
import io.github.youzhi.study.core.common.resp.RestResp;
import io.github.youzhi.study.dao.entity.Comments;
import io.github.youzhi.study.dao.mapper.CommentsMapper;
import io.github.youzhi.study.dto.req.CommentGetReqDto;
import io.github.youzhi.study.dto.req.CommentsReqDto;
import io.github.youzhi.study.dto.resp.CommentsRespDto;
import io.github.youzhi.study.manager.cache.CommentsCacheManager;
import io.github.youzhi.study.service.CommentsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
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

    private final CommentsMapper commentsMapper;

    @Override
    public RestResp<List<CommentsRespDto>> getComments(CommentGetReqDto commentGetReqDto) {
        if (commentGetReqDto.getType_id() == 1) {
            return RestResp.ok(commentsCacheManager.getComments(commentGetReqDto.getPost_id()));
        }else{
            return null;
        }
    }


    @Override
    public RestResp insertComments(CommentsReqDto commentsReqDto) {

        if (commentsReqDto.getType_id() == 1) {
            try{
                Comments comments = new Comments();
                comments.setPostId(commentsReqDto.getPost_id());
                comments.setContent(commentsReqDto.getTitle());
                comments.setCreateTime(LocalDateTime.now());
                comments.setUpdataTime(LocalDateTime.now());
                comments.setIsDeleted(false);
                comments.setUserId(UserHolder.getUserId());
                comments.setLikes(0L);
                commentsMapper.insert(comments);
                commentsCacheManager.delComments(commentsReqDto.getPost_id());
                return RestResp.ok();
            }catch (Exception e) {
                e.printStackTrace();
                return RestResp.fail(ErrorCodeEnum.USER_COMMENT);
            }
        }else {
            return null;
        }
    }
}
