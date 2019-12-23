package com.xhf.cache.service;

import com.xhf.cache.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.*;

/**
 * @author 谢红飞
 * @Title:
 * @Description:
 * @date 2019-12-22 16:03
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Test
    public void getUserById() throws InterruptedException {

        User user2 = userService.getUserTwo(2L);
        //从缓存1获取不到
        user2 = userService.getUserOne(2L);

        TimeUnit.SECONDS.sleep(6);
        //缓存2超时5秒
        user2 = userService.getUserTwo(2L);
        //缓存1超时10秒
        user2 = userService.getUserOne(2L);

    }

}