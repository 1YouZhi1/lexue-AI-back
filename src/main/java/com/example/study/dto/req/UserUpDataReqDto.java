package com.example.study.dto.req;

import lombok.Builder;
import lombok.Data;

/**
 * 用户更新数据 接收DTO
 *
 * @Author YouZhi
 * @Date 2023 - 09 - 15 - 16:43
 */
@Data
@Builder
public class UserUpDataReqDto {

    /**
     * 昵称
     */
    private String nickName;

    /**
     * 用户性别
     */
    private Integer userSex;

    /**
     * 用户头像
     */
    private String userPhoto;

    /**
     * 用户背景图片
     */
    private String backUrl;

}
