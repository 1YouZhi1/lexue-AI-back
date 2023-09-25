package io.github.youzhi.study.service;

import io.github.youzhi.study.core.common.resp.RestResp;
import io.github.youzhi.study.dto.req.PostsReqDto;
import io.github.youzhi.study.dto.resp.PostsInfoRespDto;
import io.github.youzhi.study.dto.resp.PostsRespDto;

import java.util.List;

/**
 * 帖子 服务类
 *
 * @Author YouZhi
 * @Date 2023 - 09 - 13 - 12:54
 */
public interface PostsService {

    /**
     * 获取帖子数量
     * @param num
     * @return
     */
    RestResp<List<PostsRespDto>> getPosts(int num);

    /**
     * 通过帖子id 查询帖子信息
     * @param id
     * @return
     */
    RestResp<PostsInfoRespDto> getPostInfo(Long id);

    /**
     * 发布帖子
     * @param dto
     * @return
     */
    RestResp insertPost(PostsReqDto dto);
}
