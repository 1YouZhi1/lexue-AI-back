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
 * @date 2023/09/15
 */
@TableName("rotation")
public class Rotation implements Serializable {

private static final long serialVersionUID = 1L;

        /**
         * 轮播图id
         */
                @TableId(value = "id", type = IdType.AUTO)
                private Integer id;

        /**
         * 轮播图片地址
         */
        private String advImage;

        /**
         * 新闻id
         */
        private Integer newsId;

        /**
         * 轮播标题
         */
        private String advTitle;

        /**
         * 轮播图展示顺序，从小到大
         */
        private Integer sort;

        /**
         * 是否展示，1:展示 0:不展示
         */
        private Boolean isShow;

        /**
         * 创建时间
         */
        private LocalDateTime createTime;

        /**
         * 更新时间 更新
         */
        private LocalDateTime updateTime;

        /**
         * 轮播类型
         */
        private Integer type;


    public Integer getId() {
            return id;
            }

        public void setId(Integer id) {
            this.id = id;
            }

    public String getAdvImage() {
            return advImage;
            }

        public void setAdvImage(String advImage) {
            this.advImage = advImage;
            }

    public Integer getNewsId() {
            return newsId;
            }

        public void setNewsId(Integer newsId) {
            this.newsId = newsId;
            }

    public String getAdvTitle() {
            return advTitle;
            }

        public void setAdvTitle(String advTitle) {
            this.advTitle = advTitle;
            }

    public Integer getSort() {
            return sort;
            }

        public void setSort(Integer sort) {
            this.sort = sort;
            }

    public Boolean getIsShow() {
            return isShow;
            }

        public void setIsShow(Boolean isShow) {
            this.isShow = isShow;
            }

    public LocalDateTime getCreateTime() {
            return createTime;
            }

        public void setCreateTime(LocalDateTime createTime) {
            this.createTime = createTime;
            }

    public LocalDateTime getUpdateTime() {
            return updateTime;
            }

        public void setUpdateTime(LocalDateTime updateTime) {
            this.updateTime = updateTime;
            }

    public Integer getType() {
            return type;
            }

        public void setType(Integer type) {
            this.type = type;
            }

@Override
public String toString() {
        return "Rotation{" +
                "id=" + id +
                ", advImage=" + advImage +
                ", newsId=" + newsId +
                ", advTitle=" + advTitle +
                ", sort=" + sort +
                ", isShow=" + isShow +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", type=" + type +
        "}";
        }
        }
