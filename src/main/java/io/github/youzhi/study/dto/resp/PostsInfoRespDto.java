package io.github.youzhi.study.dto.resp;

import java.io.Serial;
import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

import lombok.Builder;
import lombok.Data;

/**
 * 帖子内容 响应类 dto
 *
 * @Author YouZhi
 * @Date 2023 - 09 - 13 - 14:22
 */
@Data
@Builder
public class PostsInfoRespDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    /**
     * 帖子id
     */
    private Long p_id;

    /**
     * 帖子主题
     */
    private String title;

    /**
     * 帖子内容
     */
    private String content;

    /**
     * 图片地址
     */
    private List<String> imgUrl;

    /**
     * 点赞数量
     */
    private Long likes;

    /**
     * 评论数
     */
    private Long comments;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 用户id
     */
    private Long u_id;

    /**
     * 用户名字
     */
    private String nickName;

    /**
     * 用户头像
     */
    private String userPhoto;

}
