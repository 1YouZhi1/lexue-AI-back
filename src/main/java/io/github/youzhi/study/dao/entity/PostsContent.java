package io.github.youzhi.study.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author YouZhi
 * @date 2023/09/13
 */
@TableName("posts_content")
public class PostsContent implements Serializable {

private static final long serialVersionUID = 1L;

        /**
         * 帖子内容id
         */
                @TableId(value = "content_id", type = IdType.AUTO)
                private Long contentId;

        /**
         * 帖子id
         */
        private Long pId;

        /**
         * 帖子内容
         */
        private String postsContent;


    public Long getContentId() {
            return contentId;
            }

        public void setContentId(Long contentId) {
            this.contentId = contentId;
            }

    public Long getpId() {
            return pId;
            }

        public void setpId(Long pId) {
            this.pId = pId;
            }

    public String getPostsContent() {
            return postsContent;
            }

        public void setPostsContent(String postsContent) {
            this.postsContent = postsContent;
            }

@Override
public String toString() {
        return "PostsContent{" +
                "contentId=" + contentId +
                ", pId=" + pId +
                ", postsContent=" + postsContent +
        "}";
        }
        }
