package com.example.study.manager.cache;

import java.util.ArrayList;
import java.util.List;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.study.core.constant.CacheConsts;
import com.example.study.dao.entity.Comments;
import com.example.study.dao.entity.UserInfo;
import com.example.study.dao.mapper.CommentsMapper;
import com.example.study.dao.mapper.UserInfoMapper;
import com.example.study.dto.resp.CommentsRespDto;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

/**
 * 评论 缓存类
 *
 * @Author YouZhi
 * @Date 2023 - 09 - 17 - 21:08
 */
@Component
@RequiredArgsConstructor
public class CommentsCacheManager {

    private final CommentsMapper commentsMapper;

    private final UserInfoMapper userInfoMapper;

    @Cacheable(cacheManager = CacheConsts.REDIS_CACHE_MANAGER, value =CacheConsts.COMMENTS_CACHE_MANAGER)
    public List<CommentsRespDto> getComments(Long p_id){
        QueryWrapper<Comments> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("comment_id,content,user_id,create_time,likes")
                .eq("post_id", p_id)
                .eq("is_deleted", false);
        List<Comments> comments = commentsMapper.selectList(queryWrapper);

        List<CommentsRespDto> commentsRespDtoList = new ArrayList<>();

        for(Comments comments1 : comments){
            QueryWrapper<UserInfo> userInfoQueryWrapper = new QueryWrapper<>();
            userInfoQueryWrapper.select("nick_name, user_photo")
                    .eq("id", comments1.getUserId());
            UserInfo userInfo = userInfoMapper.selectOne(userInfoQueryWrapper);

            commentsRespDtoList.add(CommentsRespDto.builder()
                            .c_id(comments1.getCommentId())
                    .post_id(comments1.getPostId())
                    .title(comments1.getContent())
                    .user_id(comments1.getUserId())
                    .imageUrl(userInfo.getUserPhoto())
                    .nickName(userInfo.getNickName())
                    .likes(comments1.getLikes())
                    .create_time(comments1.getCreateTime())
                    .build());
        }
        return commentsRespDtoList;
    }

    @CacheEvict(cacheManager = CacheConsts.REDIS_CACHE_MANAGER, value =CacheConsts.COMMENTS_CACHE_MANAGER)
    public void delComments(Long p_id) {

    }

}
