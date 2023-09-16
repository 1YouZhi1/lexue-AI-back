package com.example.study.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 
 * </p>
 *
 * @author YouZhi
 * @date 2023/09/16
 */
public class Comments implements Serializable {

private static final long serialVersionUID = 1L;

        /**
         * 评论id
         */
                @TableId(value = "comment_id", type = IdType.AUTO)
                private Long commentId;

        /**
         * 帖子id
         */
        private Long postId;

        /**
         * 帖子评论
         */
        private String content;

        /**
         * 用户id
         */
        private Long userId;

        /**
         * 上传时间
         */
        private LocalDateTime createTime;

        /**
         * 修改时间
         */
        private LocalDateTime updataTime;

        /**
         * 记录用户评论点赞数
         */
        private Long likes;

        /**
         * 是否被删除
         */
        private Boolean isDeleted;


    public Long getCommentId() {
            return commentId;
            }

        public void setCommentId(Long commentId) {
            this.commentId = commentId;
            }

    public Long getPostId() {
            return postId;
            }

        public void setPostId(Long postId) {
            this.postId = postId;
            }

    public String getContent() {
            return content;
            }

        public void setContent(String content) {
            this.content = content;
            }

    public Long getUserId() {
            return userId;
            }

        public void setUserId(Long userId) {
            this.userId = userId;
            }

    public LocalDateTime getCreateTime() {
            return createTime;
            }

        public void setCreateTime(LocalDateTime createTime) {
            this.createTime = createTime;
            }

    public LocalDateTime getUpdataTime() {
            return updataTime;
            }

        public void setUpdataTime(LocalDateTime updataTime) {
            this.updataTime = updataTime;
            }

    public Long getLikes() {
            return likes;
            }

        public void setLikes(Long likes) {
            this.likes = likes;
            }

    public Boolean getIsDeleted() {
            return isDeleted;
            }

        public void setIsDeleted(Boolean isDeleted) {
            this.isDeleted = isDeleted;
            }
    
@Override
public String toString() {
        return "Comments{" +
                "commentId=" + commentId +
                ", postId=" + postId +
                ", content=" + content +
                ", userId=" + userId +
                ", createTime=" + createTime +
                ", updataTime=" + updataTime +
                ", likes=" + likes +
                ", isDeleted=" + isDeleted +
        "}";
        }
        }
