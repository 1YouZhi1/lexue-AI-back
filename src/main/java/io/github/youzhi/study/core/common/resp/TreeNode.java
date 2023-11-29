package io.github.youzhi.study.core.common.resp;

import lombok.Data;

import java.util.List;
import java.util.ArrayList;

@Data
public class TreeNode {
    private Long id;
    private String label;
    private List<TreeNode> children = new ArrayList<>();
}
