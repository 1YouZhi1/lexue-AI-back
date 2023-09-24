package com.example.study;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.example.study.core.constant.DatabaseConsts;
import com.example.study.dao.entity.Posts;
import com.example.study.dao.entity.PostsImage;
import com.example.study.dao.mapper.PostsImageMapper;
import com.example.study.dao.mapper.PostsMapper;
import lombok.RequiredArgsConstructor;
import org.apache.http.client.utils.HttpClientUtils;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;

@SpringBootTest
@Component
@RequiredArgsConstructor
class StudyApplicationTests {


    @Test
    void contextLoads() {


    }

}
