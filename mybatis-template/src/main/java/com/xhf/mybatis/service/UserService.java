package com.xhf.mybatis.service;

import com.github.pagehelper.PageInfo;
import com.xhf.mybatis.entity.User;

/**
 * @author 谢红飞
 * @Title:
 * @Description:
 * @date 2019-11-29 22:14
 */
public interface UserService {

    PageInfo findByPage(User user, Integer pageNum, Integer pageSize);
}
