package com.user.manager.web.service.impl;

import com.user.manager.web.service.IUploadService;
import com.user.manager.web.util.ReturnUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

@Slf4j
@Service
public class UploadServiceImpl implements IUploadService {

    @Autowired
    HttpSession session;

    /**
     * 上传管理
     *
     * @param file
     * @return
     */
    @Override
    public ReturnUtils upload(MultipartFile file) {
        if (file.isEmpty()) {
            return ReturnUtils.error("文件不能为空");
        }
        StringBuffer sb = new StringBuffer();

        try {
            // 创建字符输入流
            InputStreamReader streamReader = new InputStreamReader(file.getInputStream());
            // 放入缓冲区
            BufferedReader reader = new BufferedReader(streamReader);
            // 逐行读取
            String line = null;
            while ((line = reader.readLine()) != null) {
                sb.append(line);
            }
        } catch (IOException e) {
            log.error("文件解析失败");
        }

        if (StringUtils.isEmpty(sb.toString())) {
            return ReturnUtils.error("文件内容为空");
        }
        // 按空格分隔数据 顺便过滤为空的数据
        List<String> splitList = Arrays.stream(sb.toString().split(" ")).filter(s -> !s.equals("")).collect(Collectors.toList());

        //存入session中
        session.setAttribute(session.getId(), splitList);

        return ReturnUtils.success(splitList);
    }
}
