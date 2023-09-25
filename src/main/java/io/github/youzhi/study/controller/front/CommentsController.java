package io.github.youzhi.study.controller.front;

import io.github.youzhi.study.core.common.resp.RestResp;
import io.github.youzhi.study.core.constant.ApiRouterConsts;
import io.github.youzhi.study.dto.req.CommentGetReqDto;
import io.github.youzhi.study.dto.req.CommentsReqDto;
import io.github.youzhi.study.dto.resp.CommentsRespDto;
import io.github.youzhi.study.service.CommentsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/get")
    public RestResp<List<CommentsRespDto>> getComments(@RequestBody CommentGetReqDto commentGetReqDto) {
        return commentsService.getComments(commentGetReqDto);
    }

    @PostMapping
    public RestResp insertComments(@RequestBody CommentsReqDto commentsReqDto) {
        return commentsService.insertComments(commentsReqDto);
    }

}
