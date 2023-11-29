package io.github.youzhi.study.controller.back;

import io.github.youzhi.study.core.common.resp.RestResp;
import io.github.youzhi.study.core.common.resp.TreeNode;
import io.github.youzhi.study.core.constant.ApiRouterConsts;
import io.github.youzhi.study.dao.entity.ClassType;
import io.github.youzhi.study.service.ClassService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author YouZhi
 * @Date 2023 - 11 - 27 - 10:55
 */
@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(ApiRouterConsts.API_BACK_CLASS_URL_PREFIX)
public class ClassAdminController {

    private final ClassService classService;

    @GetMapping("/selectTree")
    public RestResp<List<TreeNode>> selectTree() {
        return classService.selectTree();
    }

    @GetMapping("/getType")
    public RestResp<List<ClassType>> getTypeAll() {
        return classService.getTypeAll();
    }

    @PostMapping("/insert")
    public RestResp<Void> insert(@RequestBody ClassType classType) {
        return classService.insert(classType);
    }
}
