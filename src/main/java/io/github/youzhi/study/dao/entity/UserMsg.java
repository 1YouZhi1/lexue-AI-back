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
 * @date 2023/09/15
 */
@TableName("user_msg")
public class UserMsg implements Serializable {

private static final long serialVersionUID = 1L;

        /**
         * 用户额外信息id
         */
                @TableId(value = "id", type = IdType.AUTO)
                private Long id;

        /**
         * 用户id
         */
        private Long uId;

        /**
         * 用户背景图片
         */
        private String backUrl;


    public Long getId() {
            return id;
            }

        public void setId(Long id) {
            this.id = id;
            }

    public Long getuId() {
            return uId;
            }

        public void setuId(Long uId) {
            this.uId = uId;
            }

    public String getBackUrl() {
            return backUrl;
            }

        public void setBackUrl(String backUrl) {
            this.backUrl = backUrl;
            }

@Override
public String toString() {
        return "UserMsg{" +
                "id=" + id +
                ", uId=" + uId +
                ", backUrl=" + backUrl +
        "}";
        }
        }
