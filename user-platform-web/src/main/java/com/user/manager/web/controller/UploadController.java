package com.user.manager.web.controller;

import com.user.manager.web.service.IUploadService;
import com.user.manager.web.util.ReturnUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@Api(tags = "上传管理")
@RequestMapping("/upload")
@RestController
public class UploadController {

    @Autowired
    IUploadService iUploadService;

    @ApiOperation(value = "文件上传")
    @PostMapping("/file")
    public ReturnUtils upload(@RequestBody MultipartFile file) {
        return iUploadService.upload(file);
    }

}
