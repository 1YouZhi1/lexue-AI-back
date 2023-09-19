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
 * @date 2023/09/19
 */
@TableName("class_type")
public class ClassType implements Serializable {

private static final long serialVersionUID = 1L;

        /**
         * 课程类型
         */
                @TableId(value = "id", type = IdType.AUTO)
                private Long id;

        /**
         * 类型名
         */
        private String className;

        /**
         * 父类
         */
        private Long fatherId;


    public Long getId() {
            return id;
            }

        public void setId(Long id) {
            this.id = id;
            }

    public String getClassName() {
            return className;
            }

        public void setClassName(String className) {
            this.className = className;
            }

    public Long getFatherId() {
            return fatherId;
            }

        public void setFatherId(Long fatherId) {
            this.fatherId = fatherId;
            }
    
@Override
public String toString() {
        return "ClassType{" +
                "id=" + id +
                ", className=" + className +
                ", fatherId=" + fatherId +
        "}";
        }
        }
