package com.xhf.demo.service;

import com.xhf.demo.entity.User;

import java.util.List;

/**
 * @author 谢红飞
 * @Title:
 * @Package
 * @Description:
 * @date 2019-8-29 23:11
 */
public interface UserService {


    List<User> findAll();

    User findOne(Integer id);
}
