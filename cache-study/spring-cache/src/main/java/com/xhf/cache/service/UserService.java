package com.xhf.cache.service;

import com.xhf.cache.entity.Emp;
import com.xhf.cache.entity.User;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

/**
 * @author 谢红飞
 * @Title:
 * @Description:
 * @date 2019-12-20 23:39
 */
@Service
public class UserService {


    @Cacheable(value = "userCacheOne", key = "#id", unless = "#result==null")
    public User getUserOne(Long id) {

        if (id.equals(1L))
            return User.builder().id(1L).username("one").build();
        if (id.equals(2L))
            return User.builder().id(2L).username("two").build();
        if (id.equals(3L))
            return User.builder().id(3L).username("three").build();
        if (id.equals(4L))
            return User.builder().id(4L).username("four").build();
        if (id.equals(5L))
            return User.builder().id(5L).username("five").build();

        return null;
    }

    @Cacheable(value = "userCacheTwo", key = "#id", unless = "#result==null")
    public User getUserTwo(Long id) {

        if (id.equals(1L))
            return User.builder().id(1L).username("one").build();
        if (id.equals(2L))
            return User.builder().id(2L).username("two").build();
        if (id.equals(3L))
            return User.builder().id(3L).username("three").build();
        if (id.equals(4L))
            return User.builder().id(4L).username("four").build();
        if (id.equals(5L))
            return User.builder().id(5L).username("five").build();

        return null;
    }


}
