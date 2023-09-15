package com.example.study.service;
import java.util.List;
import com.example.study.core.common.resp.RestResp;
import com.example.study.dao.entity.Notice;

/**
 * 通告服务类
 *
 * @Author YouZhi
 * @Date 2023 - 09 - 15 - 14:19
 */
public interface NoticeService {

    /**
     * 获取通告
     * @return
     */
    RestResp<List<Notice>> getNotice();

}
