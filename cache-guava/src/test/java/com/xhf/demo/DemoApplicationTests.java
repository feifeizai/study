package com.xhf.demo;

import com.xhf.demo.cache.UserGuavaCache;
import com.xhf.demo.entity.User;
import com.xhf.demo.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DemoApplicationTests {


    @Autowired
    UserService userService;

    @Test
    public void contextLoads() {

        List<User> all = userService.findAll();
        System.out.println(all.toString());

    }


    @Autowired
    UserGuavaCache userGuavaCache;

    @Test
    public void guavaTest1() throws ExecutionException {

        User user = userGuavaCache.getUser(7);
        User user22 = userGuavaCache.getUser(7);
        User user23 = userGuavaCache.getUser(23);

        System.out.println("guavaTest1:" + user.toString());
    }

    @Test
    public void guavaTest2() throws ExecutionException {

        List<User> users = userGuavaCache.getAllUsers();
        System.out.println("guavaTest2:" + users.toString());
    }

    @Test
    public void cacheableTest1() {

        User user1 = userService.findById(7);
        User user2 = userService.findById(7);
        User user3 = userService.findById(22);

    }

    @Test
    public void cacheableTest2() {

        User user1 = userService.findById(7);
        System.out.println(user1.toString());
        user1.setEmail("b@bb");
        User update = userService.update(user1);
        System.out.println(update.toString());

        User user2 = userService.findById(7);

    }

    @Test
    public void cacheableTest3() throws InterruptedException {

        User user1 = userService.findById(7);
        System.out.println(user1.toString());

        User user2 = userService.findByIdRedis(7);
        System.out.println(user2.toString());

        User user3 = userService.selectById(7);
        System.out.println(user3.toString());

        TimeUnit.SECONDS.sleep(7);

        User user11 = userService.findById(7);
        System.out.println("保存到user中的缓存设置超时时间, 需要重新查询");

        User user4 = userService.findByIdRedis(7);
        System.out.println("保存到userCache中的缓存设置超时时间, 需要重新查询");

        User user31 = userService.selectById(7);
        System.out.println("保存到manage中的缓存未使用redis缓存, 不需要重新查询");
    }
}
