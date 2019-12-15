package com.xhf.mybatis.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.xhf.mybatis.entity.User;
import com.xhf.mybatis.entity.UserExample;
import com.xhf.mybatis.mapper.UserMapper;
import com.xhf.mybatis.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author 谢红飞
 * @Title:
 * @Description:
 * @date 2019-11-29 22:14
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public PageInfo<User> findByPage(User user, Integer pageNum, Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        UserExample example = new UserExample();
        example.createCriteria().andIdGreaterThan(20L);
        List<User> list = userMapper.selectByExample(example);
        PageInfo<User> pageInfo = new PageInfo(list);
        return pageInfo;
    }

}
