package com.user.manager.web.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.user.manager.web.entity.TbUser;
import com.user.manager.web.mapper.TbUserMapper;
import com.user.manager.web.service.ITbUserService;
import com.user.manager.web.util.ReturnUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Map;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author young
 * @since 2020-05-23
 */
@Service
public class TbUserServiceImpl extends ServiceImpl<TbUserMapper, TbUser> implements ITbUserService {

    /**
     * 分页查询用户列表
     *
     * @param param
     * @return
     */
    @Override
    public ReturnUtils page(Map<String, String> param) {
        String keyword = param.get("keyword");
        QueryWrapper<TbUser> queryWrapper = new QueryWrapper();
        //  根据关键词模糊查询
        if (!StringUtils.isEmpty(keyword)) {
            queryWrapper.lambda().like(TbUser::getName, keyword)
                    .or()
                    .like(TbUser::getId, keyword)
                    .or()
                    .like(TbUser::getIdCard, keyword)
                    .or()
                    .like(TbUser::getUsername, keyword)
            ;
        }
        queryWrapper.lambda().orderBy(true, false, TbUser::getCreateTime);
        Page<TbUser> page = this.page(new Page<TbUser>(Long.parseLong(param.get("page")), Long.parseLong(param.get("size"))), queryWrapper);
        return ReturnUtils.success(page);
    }

    /**
     * 添加或更新用户信息
     *
     * @param tbUser
     * @return
     */
    @Override
    public ReturnUtils addOrUpdate(TbUser tbUser) {
        Long stsTime = System.currentTimeMillis();
        if (tbUser.getId() != null && tbUser.getId() > 0) {
            tbUser.setUpdateTime(stsTime);
        } else {
            tbUser.setUpdateTime(stsTime);
            tbUser.setCreateTime(stsTime);
        }
        return this.saveOrUpdate(tbUser) ? ReturnUtils.success() : ReturnUtils.error();
    }

    /**
     * 删除用户信息
     *
     * @param id
     * @return
     */
    @Override
    public ReturnUtils deleteUser(String id) {
        return this.removeById(id) ? ReturnUtils.success() : ReturnUtils.error();
    }
}
