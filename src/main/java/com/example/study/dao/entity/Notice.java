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
 * @date 2023/09/15
 */
@TableName("notice")
public class Notice implements Serializable {

private static final long serialVersionUID = 1L;

        /**
         * 通告 id
         */
                @TableId(value = "id", type = IdType.AUTO)
                private Long id;

        /**
         * 通告文本
         */
        private String title;

        /**
         * 对应类型 id
         */
        private Long chartId;

        /**
         * 类型 比如新闻 帖子
         */
        private Integer type;


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

    public Long getChartId() {
            return chartId;
            }

        public void setChartId(Long chartId) {
            this.chartId = chartId;
            }

    public Integer getType() {
            return type;
            }

        public void setType(Integer type) {
            this.type = type;
            }

@Override
public String toString() {
        return "Notice{" +
                "id=" + id +
                ", title=" + title +
                ", chartId=" + chartId +
                ", type=" + type +
        "}";
        }
        }
