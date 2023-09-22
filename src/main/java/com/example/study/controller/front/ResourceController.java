package com.example.study.controller.front;

import com.example.study.core.common.resp.RestResp;
import com.example.study.core.constant.ApiRouterConsts;
import com.example.study.service.ResourceService;
import io.swagger.v3.oas.annotations.Operation;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @Author YouZhi
 * @Date 2023 - 09 - 12 - 14:12
 */
@RestController
@RequestMapping(ApiRouterConsts.API_FRONT_RESOURCE_URL_PREFIX)
@RequiredArgsConstructor
public class ResourceController {

    private final ResourceService resourceService;

    /**
     * 图片上传接口
     */
    @Operation(summary = "图片上传接口")
    @PostMapping("/image")
    RestResp<String> uploadImage(@RequestParam("file") MultipartFile file) {
        return resourceService.uploadImage(file);
    }

    /**
     * 视频文件上传
     * @param request
     * @return
     * @throws Exception
     */
    @PostMapping(value ="/video")
    public RestResp<Map<String, Object>> uploadVideo(@RequestParam("file") MultipartFile file,HttpServletRequest request){
        return resourceService.uploadVideo(file, request);
    }







}
