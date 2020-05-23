package com.user.manager.web.controller;


import com.user.manager.web.entity.TbUser;
import com.user.manager.web.service.ITbUserService;
import com.user.manager.web.util.ReturnUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author young
 * @since 2020-05-23
 */
@Api(tags = "用户管理")
@RestController
@RequestMapping("/user/tb-user")
public class TbUserController {

    @Autowired
    ITbUserService iTbUserService;

    @GetMapping("/page")
    @ApiOperation(value = "分页获取用户列表")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "页码", value = "page", type = "int", required = true),
            @ApiImplicitParam(name = "条数", value = "size", type = "int", required = true),
            @ApiImplicitParam(name = "关键词", value = "keyword", type = "string"),
    })
    public ReturnUtils page(@RequestParam Map<String, String> param) {
        return iTbUserService.page(param);
    }

    @PostMapping("addOrUpdate")
    @ApiOperation(value = "添加或更新用户信息")
    public ReturnUtils addOrUpdate(@RequestBody TbUser tbUser) {
        return iTbUserService.addOrUpdate(tbUser);
    }

    @DeleteMapping("/delete/user/{id}")
    @ApiOperation(value = "删除用户信息")
    public ReturnUtils deleteUser(@PathVariable String id) {
        return iTbUserService.deleteUser(id);
    }
}
