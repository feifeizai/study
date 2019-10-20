package com.xhf.demo.service.impl;

import com.xhf.demo.dao.UserDao;
import com.xhf.demo.entity.User;
import com.xhf.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author 谢红飞
 * @Title:
 * @Package
 * @Description:
 * @date 2019-8-29 23:12
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public List<User> findAll(){
        return userDao.findAll();
    }

    @Override
    public User findOne(Integer id){
        Optional<User> optional = userDao.findById(id);
        if(optional.isPresent()){
            return optional.get();
        }
        return null;
    }

}
