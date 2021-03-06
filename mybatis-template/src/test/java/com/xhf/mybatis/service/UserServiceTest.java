package com.xhf.mybatis.service;

import com.github.pagehelper.PageInfo;
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

        PageInfo<User> page = userService.findByPage(user, 1, 2);

        List<User> list = page.getList();
        for (User u : list) {
            System.out.println(u.toString());
        }
    }
}