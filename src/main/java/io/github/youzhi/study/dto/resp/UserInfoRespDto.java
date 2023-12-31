package io.github.youzhi.study.dto.resp;

import lombok.Builder;
import lombok.Data;

/**
 * 用户信息查询 响应类
 *
 * @Author YouZhi
 * @Date 2023 - 09 - 11 - 10:04
 */
@Data
@Builder
public class UserInfoRespDto {

    /**
     * 昵称
     * */
    private String nickName;

    /**
     * 用户头像
     * */
    private String userPhoto;

    /**
     * 用户性别
     * */
    private Integer userSex;

    /**
     * 用户额外信息id
     */
    private Long otherInfo_id;

    /**
     * 用户背景图片
     */
    private String backUrl;
}
