package com.mju.bishe.controller;
import com.mju.bishe.common.Result;
import com.mju.bishe.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@Api(value = "用户接口", tags = "用户接口")
@RestController
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService targetService;
    /**
     * 登录检查
     */
    @ApiOperation(value = "登录检查", notes = "登录检查")
    @PostMapping(value = "/login")
    @ResponseBody
    public Result login(@RequestBody Map map){
        return targetService.loginCheck(map);
    }
}
