package com.xhf.demo.cache;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import com.google.common.cache.CacheLoader;
import com.google.common.cache.LoadingCache;
import com.xhf.demo.entity.User;
import com.xhf.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

/**
 * @author 谢红飞
 * @date 2019-8-29 23:16
 */
@Component
public class UserCache {

    @Autowired
    private UserService userService;

    private static final String CACHE_KEY = "CACHE_KEY";

    /**
     * 保存id-bean, 定时根据id查询对应的bean
     */
    private static Cache<Integer, User> userCache =
            CacheBuilder.newBuilder()
                    .expireAfterWrite(30, TimeUnit.SECONDS)
                    .maximumSize(2000)
                    .build();

    /**
     * 这个是定时从数据库同步全部数据
     */
    private LoadingCache<String, List<User>> userListCache;

    @PostConstruct
    public void init() {
        userListCache = CacheBuilder.newBuilder()
                .refreshAfterWrite(30, TimeUnit.SECONDS)
                .maximumSize(20)
                .build(new CacheLoader<String, List<User>>() {
                    @Override
                    public List<User> load(String key){
                        return userService.findAll();
                    }
                });
    }


    public User getUser(Integer id) throws ExecutionException {
        User user = userCache.get(id, new Callable<User>() {
            @Override
            public User call() {
                return userService.findOne(id);
            }
        });

        return user;
    }


    public List<User> getAllUsers() throws ExecutionException {
        return userListCache.get(CACHE_KEY);
    }

}
