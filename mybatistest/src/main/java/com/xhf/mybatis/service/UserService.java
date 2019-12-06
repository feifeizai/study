package com.xhf.mybatis.service;

import com.xhf.mybatis.entity.User;

import java.util.Map;

public interface UserService {
    User findUserById(Integer userId);

    User findUser(Integer userId);

    Map<String,Object> findUserMap(Integer userId);
}
