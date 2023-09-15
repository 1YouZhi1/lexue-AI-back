package com.example.study.controller.front;

import com.example.study.core.common.resp.RestResp;
import com.example.study.core.constant.ApiRouterConsts;
import com.example.study.dao.entity.Notice;
import com.example.study.service.NoticeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 通告 接口层
 *
 * @Author YouZhi
 * @Date 2023 - 09 - 15 - 15:05
 */
@RestController
@RequiredArgsConstructor
@RequestMapping(ApiRouterConsts.API_NOTICE_URL_PREFIX)
public class NoticeController {

    private final NoticeService noticeService;

    @GetMapping
    public RestResp<List<Notice>> getNotice() {
        return noticeService.getNotice();
    }

}
