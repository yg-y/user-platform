package com.user.manager.web.controller;

import com.user.manager.web.service.IFrequentService;
import com.user.manager.web.util.ReturnUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Api(tags = "频词统计管理")
@RequestMapping("/frequent")
@RestController
public class FrequentController {

    @Autowired
    IFrequentService iFrequentService;

    @ApiOperation(value = "获取上传的频词统计结果集")
    @GetMapping("/result")
    public ReturnUtils result() {
        return iFrequentService.result();
    }
}
