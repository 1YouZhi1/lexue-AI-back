package io.github.youzhi.study.dao.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author YouZhi
 * @date 2023/09/24
 */
@TableName("class_love")
@Data
public class ClassLove implements Serializable {

private static final long serialVersionUID = 1L;

        /**
         * id自增
         */
                @TableId(value = "id", type = IdType.AUTO)
                private Long id;

        /**
         * 用户id
         */
        private Long uId;

        /**
         * 课程id
         */
        private Long cId;


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

    public Long getcId() {
            return cId;
            }

        public void setcId(Long cId) {
            this.cId = cId;
            }

    public ClassLove( Long uId, Long cId) {
        this.uId = uId;
        this.cId = cId;
    }

    public ClassLove() {
    }

    @Override
public String toString() {
        return "ClassLove{" +
                "id=" + id +
                ", uId=" + uId +
                ", cId=" + cId +
        "}";
        }
        }
