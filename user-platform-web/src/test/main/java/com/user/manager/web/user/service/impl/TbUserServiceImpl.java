package com.user.manager.web.user.service.impl;

import com.user.manager.web.user.entity.TbUser;
import com.user.manager.web.user.mapper.TbUserMapper;
import com.user.manager.web.user.service.ITbUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author young
 * @since 2020-05-23
 */
@Service
public class TbUserServiceImpl extends ServiceImpl<TbUserMapper, TbUser> implements ITbUserService {

}
