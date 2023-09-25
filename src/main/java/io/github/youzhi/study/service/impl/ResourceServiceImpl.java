package io.github.youzhi.study.service.impl;

import com.baomidou.mybatisplus.core.toolkit.IdWorker;
import io.github.youzhi.study.core.common.constant.ErrorCodeEnum;
import io.github.youzhi.study.core.common.exception.BusinessException;
import io.github.youzhi.study.core.common.resp.RestResp;
import io.github.youzhi.study.core.constant.SystemConfigConsts;
import io.github.youzhi.study.core.utils.FrameGrabberKit;
import io.github.youzhi.study.service.ResourceService;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.io.File;
import java.nio.file.Files;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * 图片资源上传 实现类
 *
 * @Author YouZhi
 * @Date 2023 - 09 - 12 - 14:05
 */

@RequiredArgsConstructor
@Slf4j
@Service
public class ResourceServiceImpl implements ResourceService {

    @Value("${study.file.upload.path}")
    private String fileUploadPath;

    @SneakyThrows
    @Override
    public RestResp<String> uploadImage(MultipartFile file) {
        System.out.println("配置文件路劲" +fileUploadPath );
        LocalDateTime now = LocalDateTime.now();
        String savePath =
                SystemConfigConsts.IMAGE_UPLOAD_DIRECTORY
                        + now.format(DateTimeFormatter.ofPattern("yyyy")) + File.separator
                        + now.format(DateTimeFormatter.ofPattern("MM")) + File.separator
                        + now.format(DateTimeFormatter.ofPattern("dd"));
        System.out.println("保存路径" + savePath);
        String oriName = file.getOriginalFilename();
        assert oriName != null;
        String saveFileName = IdWorker.get32UUID() + oriName.substring(oriName.lastIndexOf("."));
        System.out.println("名字" + saveFileName);
        File saveFile = new File(fileUploadPath + savePath, saveFileName);
        if (!saveFile.getParentFile().exists()) {
            boolean isSuccess = saveFile.getParentFile().mkdirs();
            if (!isSuccess) {
                throw new BusinessException(ErrorCodeEnum.USER_UPLOAD_FILE_ERROR);
            }
        }
        file.transferTo(saveFile);
        if (Objects.isNull(ImageIO.read(saveFile))) {
            // 上传的文件不是图片
            Files.delete(saveFile.toPath());
            throw new BusinessException(ErrorCodeEnum.USER_UPLOAD_FILE_TYPE_NOT_MATCH);
        }
        return RestResp.ok(savePath + File.separator + saveFileName);
    }

    /**
     * 视频文件上传
     */
    @SneakyThrows
    @Override
    public RestResp<Map<String, Object>> uploadVideo(MultipartFile file, HttpServletRequest request){
        Map<String, Object> resultMap = new HashMap<>();

        String savePath = generateVideoSavePath();
        // 文件原始名称
        String fileName = file.getOriginalFilename();
        // 从最后一个.开始截取。截取 fileName 的后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        // 文件新名称
        String newFileName = IdWorker.get32UUID() + suffixName;
        // 设置文件存储路径，可以存放在你想要指定的路径里面
        // 上传视频存放位置
        String videoRootPath = fileUploadPath + savePath;
        String imageRootPath = fileUploadPath + generateImageSavePath();
        String videoFilePath = videoRootPath + File.separator + newFileName;
        File saveFile = new File(videoFilePath);

        // 判断目标文件所在目录是否存在
        if (!saveFile.getParentFile().exists()) {
            boolean isSuccess = saveFile.getParentFile().mkdirs();
            if (!isSuccess) {
                throw new BusinessException(ErrorCodeEnum.USER_UPLOAD_FILE_ERROR);
            }
        }
        // 将内存中的数据写入磁盘
        file.transferTo(saveFile);
        // 视频上传保存url
        String videoUrl = savePath + File.separator + newFileName;
        // 视频封面图处理
        String newImgName = IdWorker.get32UUID() + ".jpg";
        String framefile = imageRootPath + File.separator + newImgName;
        // 图片最终位置路径
        String imgUrlSave = generateImageSavePath() + File.separator + newImgName;
        // 视频截取封面图
        String imgUrl = FrameGrabberKit.getVedioImg(videoFilePath, framefile, imgUrlSave);
        System.out.println(videoUrl);
        System.out.println(imgUrl);
        resultMap.put("videoUrl", videoUrl);
        resultMap.put("imgUrl", imgUrl);

        return RestResp.ok(resultMap);
    }


    private String generateImageSavePath() {
        LocalDateTime now = LocalDateTime.now();
        return SystemConfigConsts.IMAGE_UPLOAD_DIRECTORY
                + now.format(DateTimeFormatter.ofPattern("yyyy")) + File.separator
                + now.format(DateTimeFormatter.ofPattern("MM")) + File.separator
                + now.format(DateTimeFormatter.ofPattern("dd"));
    }

    private String generateVideoSavePath() {
        LocalDateTime now = LocalDateTime.now();
        return SystemConfigConsts.VIDEO_UPLOAD_DIRECTORY
                + now.format(DateTimeFormatter.ofPattern("yyyy")) + File.separator
                + now.format(DateTimeFormatter.ofPattern("MM")) + File.separator
                + now.format(DateTimeFormatter.ofPattern("dd"));
    }


}
