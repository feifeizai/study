package com.xhf.demo.dao;

import com.xhf.demo.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author 谢红飞
 * @Title:
 * @Package
 * @Description:
 * @date 2019-8-29 23:14
 */
public interface UserDao extends JpaRepository<User,Integer>{

    @Override
    List<User> findAll();


}
