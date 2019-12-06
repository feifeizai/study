package com.xhf.mybatis.service;

import com.xhf.mybatis.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author 谢红飞
 * @Title:
 * @Description:
 * @date 2019-11-29 22:19
 */
@SpringBootTest
public class UserServiceTest {

    @Autowired
    UserService userService;

    @Test
    void findByPage() {

        User user = new User();
        user.setId(15L);

        List<User> list = userService.findByPage(user,1, 2);

        System.out.println(list.toString());
    }
}