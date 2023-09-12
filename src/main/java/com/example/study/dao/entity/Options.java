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
 * @date 2023/09/12
 */
@TableName("options")
public class Options implements Serializable {

private static final long serialVersionUID = 1L;

                @TableId(value = "option_id", type = IdType.AUTO)
                private Long optionId;

        private Long questionId;

        /**
         * 选项内容
         */
        private String optionText;

        /**
         * 是否为正确答案
         */
        private Boolean isCorrect;


    public Long getOptionId() {
            return optionId;
            }

        public void setOptionId(Long optionId) {
            this.optionId = optionId;
            }

    public Long getQuestionId() {
            return questionId;
            }

        public void setQuestionId(Long questionId) {
            this.questionId = questionId;
            }

    public String getOptionText() {
            return optionText;
            }

        public void setOptionText(String optionText) {
            this.optionText = optionText;
            }

    public Boolean getIsCorrect() {
            return isCorrect;
            }

        public void setIsCorrect(Boolean isCorrect) {
            this.isCorrect = isCorrect;
            }

@Override
public String toString() {
        return "Options{" +
                "optionId=" + optionId +
                ", questionId=" + questionId +
                ", optionText=" + optionText +
                ", isCorrect=" + isCorrect +
        "}";
        }
        }
