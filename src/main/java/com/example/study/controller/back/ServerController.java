package com.example.study.controller.back;

import com.example.study.core.common.resp.RestResp;
import com.example.study.core.constant.ApiRouterConsts;
import com.example.study.dao.domain.Server;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author YouZhi
 * @Date 2023 - 09 - 24 - 19:30
 */
@RestController
@RequestMapping(ApiRouterConsts.API_BACK_SERVER_URL_PREFIX)
public class ServerController {
    @GetMapping()
    public RestResp getInfo() throws Exception
    {
        Server server = new Server();
        server.copyTo();
        return RestResp.ok(server);
    }
}
