package io.github.youzhi.study.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 *
 * </p>
 *
 * @author YouZhi
 * @date 2023/09/19
 */
@TableName("class_info")
public class ClassInfo implements Serializable {

private static final long serialVersionUID = 1L;

        /**
         * 课程id
         */
                @TableId(value = "id", type = IdType.AUTO)
                private Long id;

        /**
         * 课程标题
         */
        private String title;

        /**
         * 课程图片路径
         */
        private String imgUrl;

        /**
         * 标签id
         */
        private Long labelId;

        /**
         * 课程介绍
         */
        private String content;

        /**
         * 创建时间
         */
        private LocalDateTime createTime;

        /**
         * 更新时间
         */
        private LocalDateTime updateTime;

        /**
         * 课程视频
         */
        private String videoUrl;


    public Long getId() {
            return id;
            }

        public void setId(Long id) {
            this.id = id;
            }

    public String getTitle() {
            return title;
            }

        public void setTitle(String title) {
            this.title = title;
            }

    public String getImgUrl() {
            return imgUrl;
            }

        public void setImgUrl(String imgUrl) {
            this.imgUrl = imgUrl;
            }

    public Long getLabelId() {
            return labelId;
            }

        public void setLabelId(Long labelId) {
            this.labelId = labelId;
            }

    public String getContent() {
            return content;
            }

        public void setContent(String content) {
            this.content = content;
            }

    public LocalDateTime getCreateTime() {
            return createTime;
            }

        public void setCreateTime(LocalDateTime createTime) {
            this.createTime = createTime;
            }

    public LocalDateTime getUpdataTime() {
            return updateTime;
            }

        public void setUpdataTime(LocalDateTime updataTime) {
            this.updateTime = updataTime;
            }

    public String getVideoUrl() {
            return videoUrl;
            }

        public void setVideoUrl(String videoUrl) {
            this.videoUrl = videoUrl;
            }

@Override
public String toString() {
        return "ClassInfo{" +
                "id=" + id +
                ", title=" + title +
                ", imgUrl=" + imgUrl +
                ", labelId=" + labelId +
                ", content=" + content +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", videoUrl=" + videoUrl +
        "}";
        }
        }
