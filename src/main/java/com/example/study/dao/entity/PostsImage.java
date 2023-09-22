package com.example.study.dao.entity;

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
 * @date 2023/09/22
 */
@TableName("posts_image")
public class PostsImage implements Serializable {

private static final long serialVersionUID = 1L;

        /**
         * 发帖图片id
         */
                @TableId(value = "image_id", type = IdType.AUTO)
                private Long imageId;

        /**
         * 帖子id
         */
        private Long pId;

        /**
         * 图片url
         */
        private String imageUrl;

        /**
         * 排序
         */
        private Integer sort;


    public Long getImageId() {
            return imageId;
            }

        public void setImageId(Long imageId) {
            this.imageId = imageId;
            }

    public Long getpId() {
            return pId;
            }

        public void setpId(Long pId) {
            this.pId = pId;
            }

    public String getImageUrl() {
            return imageUrl;
            }

        public void setImageUrl(String imageUrl) {
            this.imageUrl = imageUrl;
            }

    public Integer getSort() {
            return sort;
            }

        public void setSort(Integer sort) {
            this.sort = sort;
            }
    
@Override
public String toString() {
        return "PostsImage{" +
                "imageId=" + imageId +
                ", pId=" + pId +
                ", imageUrl=" + imageUrl +
                ", sort=" + sort +
        "}";
        }
        }
