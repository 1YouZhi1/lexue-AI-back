package io.github.youzhi.study.controller.back;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.github.youzhi.study.core.common.resp.RestResp;
import io.github.youzhi.study.core.constant.ApiRouterConsts;
import io.github.youzhi.study.dao.entity.UserInfo;
import io.github.youzhi.study.dto.req.UserLoginReqDto;
import io.github.youzhi.study.dto.resp.AdminRespDto;
import io.github.youzhi.study.service.UserService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

/**
 * 管理员请求模块
 *
 * @Author YouZhi
 * @Date 2023 - 09 - 24 - 21:26
 */
@CrossOrigin
@RestController
@RequiredArgsConstructor
@RequestMapping(ApiRouterConsts.API_BACK_USER_URL_PREFIX)
public class AdminController {

    @NonNull
    private UserService userService;

    @GetMapping
    public RestResp<AdminRespDto> getAdmin() {
        return userService.getAdmin();
    }

    @PostMapping("login")
    public RestResp<AdminRespDto> login (@RequestBody UserLoginReqDto dto) {
        return userService.adminLogin(dto);
    }

    @PostMapping("logout")
    public RestResp logout() {
        return RestResp.ok();
    }

    @GetMapping("/list")
    public RestResp<Page<UserInfo>> getList(@RequestParam("limit") int limit, @RequestParam("page") int page, @RequestParam("title") String title) {
        return userService.getList(limit,page, title);
    }

    @PutMapping
    public RestResp updateUser(@RequestBody UserInfo userInfo) {
        return userService.updateUser(userInfo);
    }

}
