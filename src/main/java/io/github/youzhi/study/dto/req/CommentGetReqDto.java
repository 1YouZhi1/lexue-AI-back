package io.github.youzhi.study.dto.req;

import lombok.Builder;
import lombok.Data;

/**
 * 评论获取
 *
 * @Author YouZhi
 * @Date 2023 - 09 - 23 - 16:13
 */
@Data
@Builder
public class CommentGetReqDto {

    private Long post_id;

    private Long type_id;

}
