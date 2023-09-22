package com.example.study.core.utils;


import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;
import javax.imageio.ImageIO;

import lombok.extern.slf4j.Slf4j;
import org.bytedeco.javacpp.opencv_core;
import org.bytedeco.javacv.FFmpegFrameGrabber;
import org.bytedeco.javacv.Frame;
import org.bytedeco.javacv.Java2DFrameConverter;


/**
* 截取视频图片
* @author YouZhi
 * @ClassName:  FrameGrabberKit
*/
@Slf4j
public class FrameGrabberKit {

	/**
	 * 获取视频图片
	 * @param videofile  源视频文件路径
	 * @param framefile  截取帧的图片存放路径
	 * @param imgfile 视频封面图保存路径
	 * @return
	 */
	public static String getVedioImg(String videofile, String framefile,String imgfile){
		String ImgUrl="";
	    //截取封面图
		try {
			fetchFrame(videofile, framefile);
		} catch (Exception e) {
			e.printStackTrace();
		}
        // 完整的ImgUrl
        //视频封面图保存路径
       ImgUrl = imgfile;
       return ImgUrl;
	 }

    public static void fetchFrame(String videofile, String framefile) throws Exception {
        File targetFile = new File(framefile);
        if (!targetFile.getParentFile().exists()) {
            targetFile.getParentFile().mkdirs();
        }
        try {
            File videoFile = new File(videofile);
            if (videoFile.exists()) {
                log.info("文件存在，路径正确！");
                FFmpegFrameGrabber ff = new FFmpegFrameGrabber(videoFile);
                ff.start();
                int ftp = ff.getLengthInFrames();
                int flag = 0;
                Frame frame = null;
                while (flag <= ftp) {
                    frame = ff.grabImage();
                    if ((flag > 3) && (frame != null)) {
                        break;
                    }
                    flag++;
                }
                ImageIO.write(FrameToBufferedImage(frame), "jpg", targetFile);
                ff.close();
                ff.stop();
            }
        } catch (Exception e) {
            log.error("获取预览图失败", e);
        }
    }

    private static RenderedImage FrameToBufferedImage(Frame frame) {
        // 创建 BufferedImage 对象
        Java2DFrameConverter converter = new Java2DFrameConverter();
        BufferedImage bufferedImage = converter.getBufferedImage(frame);
        return bufferedImage;
    }

}

