package com.user.manager.web.service.impl;

import com.user.manager.web.service.IFrequentService;
import com.user.manager.web.util.ReturnUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class IFrequentServiceImpl implements IFrequentService {

    @Autowired
    HttpSession session;

    /**
     * 频词统计结果
     *
     * @return
     */
    @Override
    public ReturnUtils result() {
        // target
        List<String> splitList = (List<String>) session.getAttribute(session.getId());
        // 去重
        List<String> distinctList = splitList.stream().distinct().collect(Collectors.toList());
        List<Map<String, String>> resResult = new ArrayList<>();
        // 计算出现频率
        distinctList.forEach(s -> {
            Map<String, String> result = new HashMap<>();
            int count = (int) splitList.stream().filter(target -> s.toLowerCase().equals(target.toLowerCase())).count();
            result.put("key", s);
            result.put("value", String.valueOf(count));
            resResult.add(result);
        });
        return ReturnUtils.success(resResult);
    }
}
