package com.example.study.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author YouZhi
 * @date 2023/09/12
 */
public class Questions implements Serializable {

private static final long serialVersionUID = 1L;

                @TableId(value = "question_id", type = IdType.AUTO)
                private Long questionId;

        /**
         * 题目文本
         */
        private String name;

        /**
         * 题目类型
         */
        private Integer type;


    public Long getQuestionId() {
            return questionId;
            }

        public void setQuestionId(Long questionId) {
            this.questionId = questionId;
            }

    public String getName() {
            return name;
            }

        public void setName(String name) {
            this.name = name;
            }

    public Integer getType() {
            return type;
            }

        public void setType(Integer type) {
            this.type = type;
            }
    
@Override
public String toString() {
        return "Questions{" +
                "questionId=" + questionId +
                ", name=" + name +
                ", type=" + type +
        "}";
        }
        }
