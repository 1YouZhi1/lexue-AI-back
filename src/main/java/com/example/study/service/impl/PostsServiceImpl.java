package com.example.study.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.study.core.auth.UserHolder;
import com.example.study.core.common.resp.RestResp;
import com.example.study.core.constant.DatabaseConsts;
import com.example.study.dao.entity.Posts;
import com.example.study.dao.entity.PostsContent;
import com.example.study.dao.entity.PostsImage;
import com.example.study.dao.entity.UserInfo;
import com.example.study.dao.mapper.PostsContentMapper;
import com.example.study.dao.mapper.PostsImageMapper;
import com.example.study.dao.mapper.PostsMapper;
import com.example.study.dao.mapper.UserInfoMapper;
import com.example.study.dto.req.PostsReqDto;
import com.example.study.dto.resp.PostsInfoRespDto;
import com.example.study.dto.resp.PostsRespDto;
import com.example.study.service.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * 帖子 实现类
 *
 * @Author YouZhi
 * @Date 2023 - 09 - 13 - 12:54
 */
@Component
@RequiredArgsConstructor
public class PostsServiceImpl implements PostsService {

    private final PostsMapper postsMapper;

    private final PostsImageMapper postsImageMapper;

    private final PostsContentMapper postsContentMapper;

    private final UserInfoMapper userInfoMapper;

    @Override
    public RestResp<List<PostsRespDto>> getPosts(int num) {

        QueryWrapper<Posts> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("*")
                .orderByAsc("RAND()")
                .last("limit " + num);

        //随机获取指定数量的帖子
        List<Posts> randomPosts = postsMapper.selectList(queryWrapper);

        List<PostsRespDto> postsRespDtoList = new ArrayList<>();

        for (Posts posts: randomPosts) {
            QueryWrapper<PostsImage> imageWrapper = new QueryWrapper();
            imageWrapper.select("image_url")
                    .eq("p_id", posts.getPostId())
                    .orderByDesc("sort")
                    .last(DatabaseConsts.SqlEnum.LIMIT_1.getSql());
            PostsImage postsImage = postsImageMapper.selectOne(imageWrapper);
            if (postsImage != null) {
                postsRespDtoList.add(PostsRespDto.builder()
                        .p_id(posts.getPostId())
                        .title(posts.getTitle())
                        .imageUrl(postsImage.getImageUrl())
                        .likes(posts.getLikes())
                        .comments(posts.getComments())
                        .build());
            }

        }
        return RestResp.ok(postsRespDtoList);
    }

    @Override
    public RestResp<PostsInfoRespDto> getPostInfo(Long id) {

        QueryWrapper<Posts> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("*")
                .eq("post_id", id)
                .last(DatabaseConsts.SqlEnum.LIMIT_1.getSql());
        //获取帖子基本信息
        Posts posts = postsMapper.selectOne(queryWrapper);

        QueryWrapper<PostsImage> imageWrapper = new QueryWrapper();
        imageWrapper.select("image_url")
                .eq("p_id", posts.getPostId())
                .orderByDesc("sort");
        List<PostsImage> postsImages = postsImageMapper.selectList(imageWrapper);
        List<String> pUrl = new ArrayList<>();
        for(PostsImage postsImage : postsImages){
            pUrl.add(postsImage.getImageUrl());
        }

        QueryWrapper<PostsContent> postsContentQueryWrapper = new QueryWrapper<>();
        postsContentQueryWrapper.select("*")
                .eq("p_id", id)
                .last(DatabaseConsts.SqlEnum.LIMIT_1.getSql());
        String postsContent = postsContentMapper.selectOne(postsContentQueryWrapper).getPostsContent();


        UserInfo userInfo = userInfoMapper.selectById(posts.getUserId());
        System.out.println(userInfo);
        return RestResp.ok(PostsInfoRespDto.builder()
                .p_id(posts.getPostId())
                .title(posts.getTitle())
                .content(postsContent)
                .imgUrl(pUrl)
                .likes(posts.getLikes())
                .comments(posts.getComments())
                .updateTime(posts.getTimestamp())
                .u_id(posts.getUserId())
                .nickName(userInfo.getNickName())
                .userPhoto(userInfo.getUserPhoto())
                .build());
    }

    @Override
    public RestResp insertPost(PostsReqDto dto) {
        Long userId = UserHolder.getUserId();

        Posts posts = new Posts();
        posts.setUserId(userId);
        posts.setTitle(dto.getTitle());
        posts.setTimestamp(LocalDateTime.now());
        posts.setLikes(0L);
        posts.setComments(0L);
        postsMapper.insert(posts);

        PostsContent postsContent = new PostsContent();
        postsContent.setpId(posts.getPostId());
        postsContent.setPostsContent(dto.getContent());
        postsContentMapper.insert(postsContent);

        for(int i = 0; i < dto.getImageUrl().size(); i++) {
            PostsImage postsImage = new PostsImage();
            postsImage.setpId(posts.getPostId());
            System.out.println(dto.getImageUrl().get(i));
            postsImage.setImageUrl(dto.getImageUrl().get(i));

            postsImageMapper.insert(postsImage);
        }

        return RestResp.ok();
    }
}
