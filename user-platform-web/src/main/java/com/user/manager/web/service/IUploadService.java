package com.user.manager.web.service;

import com.user.manager.web.util.ReturnUtils;
import org.springframework.web.multipart.MultipartFile;

public interface IUploadService {

    ReturnUtils upload(MultipartFile file);
}
