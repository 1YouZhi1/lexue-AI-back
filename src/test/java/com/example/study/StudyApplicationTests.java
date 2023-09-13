package com.example.study;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.study.core.constant.DatabaseConsts;
import com.example.study.dao.entity.Posts;
import com.example.study.dao.entity.PostsImage;
import com.example.study.dao.mapper.PostsImageMapper;
import com.example.study.dao.mapper.PostsMapper;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;

import java.util.List;

@SpringBootTest
@Component
@RequiredArgsConstructor
class StudyApplicationTests {

    private final PostsMapper postsMapper;

    private final PostsImageMapper postsImageMapper;

    @Test
    void contextLoads() {
        int id = 2;
        QueryWrapper<Posts> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("*")
                .eq("post_id", id)
                .last(DatabaseConsts.SqlEnum.LIMIT_1.getSql());
        //获取帖子基本信息
        Posts posts = postsMapper.selectOne(queryWrapper);

        QueryWrapper<PostsImage> imageWrapper = new QueryWrapper();
        imageWrapper.select("imageUrl")
                .eq("p_id", posts.getPostId());
        PostsImage postsImages = postsImageMapper.selectOne(imageWrapper);
        System.out.println(postsImages);

    }

}
