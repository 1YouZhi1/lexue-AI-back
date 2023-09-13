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
 * @date 2023/09/13
 */
public class Posts implements Serializable {

private static final long serialVersionUID = 1L;

        /**
         * 帖子id
         */
                @TableId(value = "post_id", type = IdType.AUTO)
                private Long postId;

        /**
         * 用户id
         */
        private Long userId;

        /**
         * 帖子标题
         */
        private String title;

        /**
         * 内容
         */
        private String content;

        /**
         * 发帖时间
         */
        private LocalDateTime timestamp;

        /**
         * 点赞数
         */
        private Long likes;

        /**
         * 评论数
         */
        private Long comments;


    public Long getPostId() {
            return postId;
            }

        public void setPostId(Long postId) {
            this.postId = postId;
            }

    public Long getUserId() {
            return userId;
            }

        public void setUserId(Long userId) {
            this.userId = userId;
            }

    public String getTitle() {
            return title;
            }

        public void setTitle(String title) {
            this.title = title;
            }

    public String getContent() {
            return content;
            }

        public void setContent(String content) {
            this.content = content;
            }

    public LocalDateTime getTimestamp() {
            return timestamp;
            }

        public void setTimestamp(LocalDateTime timestamp) {
            this.timestamp = timestamp;
            }

    public Long getLikes() {
            return likes;
            }

        public void setLikes(Long likes) {
            this.likes = likes;
            }

    public Long getComments() {
            return comments;
            }

        public void setComments(Long comments) {
            this.comments = comments;
            }
    
@Override
public String toString() {
        return "Posts{" +
                "postId=" + postId +
                ", userId=" + userId +
                ", title=" + title +
                ", content=" + content +
                ", timestamp=" + timestamp +
                ", likes=" + likes +
                ", comments=" + comments +
        "}";
        }
        }
