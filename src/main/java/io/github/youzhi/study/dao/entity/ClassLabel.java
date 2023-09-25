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
 * @date 2023/09/19
 */
@TableName("class_label")
public class ClassLabel implements Serializable {

private static final long serialVersionUID = 1L;

        /**
         * 标签id
         */
                @TableId(value = "id", type = IdType.AUTO)
                private Long id;

        /**
         * 课程id
         */
        private Long cId;

        /**
         * 类型id
         */
        private Long tId;


    public Long getId() {
            return id;
            }

        public void setId(Long id) {
            this.id = id;
            }

    public Long getcId() {
            return cId;
            }

        public void setcId(Long cId) {
            this.cId = cId;
            }

    public Long gettId() {
            return tId;
            }

        public void settId(Long tId) {
            this.tId = tId;
            }

@Override
public String toString() {
        return "ClassLabel{" +
                "id=" + id +
                ", cId=" + cId +
                ", tId=" + tId +
        "}";
        }
        }
