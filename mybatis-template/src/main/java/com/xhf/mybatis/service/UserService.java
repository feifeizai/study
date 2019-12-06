package com.xhf.mybatis.service;

import com.xhf.mybatis.entity.User;

import java.util.List;

/**
 * @author 谢红飞
 * @Title:
 * @Description:
 * @date 2019-11-29 22:14
 */
public interface UserService {

    List<User> findByPage(User user, Integer pageNum, Integer pageSize);
}
