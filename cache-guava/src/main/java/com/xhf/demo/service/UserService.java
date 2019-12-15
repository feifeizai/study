package com.xhf.demo.service;

import com.xhf.demo.entity.User;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;

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

    User findById(Integer id);

    @CachePut(value = {"user"}, key = "#result.id")
    User update(User user);

    @Cacheable(value = {"user"}, key = "#id", cacheManager = "userCacheManager")
    User findByIdRedis(Integer id);

    @Cacheable(value = {"manage"}, key = "#id")
    User selectById(Integer id);
}
