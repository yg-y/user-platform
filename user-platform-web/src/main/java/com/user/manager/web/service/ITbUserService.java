package com.user.manager.web.service;

import com.user.manager.web.entity.TbUser;
import com.baomidou.mybatisplus.extension.service.IService;
import com.user.manager.web.util.ReturnUtils;

import java.util.Map;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author young
 * @since 2020-05-23
 */
public interface ITbUserService extends IService<TbUser> {

    ReturnUtils page(Map<String, String> param);

    ReturnUtils addOrUpdate(TbUser tbUser);

    ReturnUtils deleteUser(String id);
}
