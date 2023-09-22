package com.example.study.service;

import com.example.study.core.common.resp.RestResp;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.web.multipart.MultipartFile;

import java.util.Map;

/**
 * 图片资源上传接口
 *
 * @Author YouZhi
 * @Date 2023 - 09 - 12 - 14:04
 */
public interface ResourceService {
    /**
     * 图片上传
     * @param file 需要上传的图片
     * @return 图片访问路径
     * */
    RestResp<String> uploadImage(MultipartFile file);

    /**
     * 视频文件上传
     * @param request
     * @param file
     * @return
     */
    RestResp<Map<String, Object>> uploadVideo(MultipartFile file,HttpServletRequest request);

}
