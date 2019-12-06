package com.xhf.mybatis;

import com.xhf.mybatis.entity.Permission;
import com.xhf.mybatis.entity.User;
import com.xhf.mybatis.mapper.PermissionMapper;
import com.xhf.mybatis.mapper.UserMapper;
import com.xhf.mybatis.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MybatistestApplicationTests {

	@Autowired
	UserService userService;
	@Autowired
	PermissionMapper permissionMapper;

	@Test
	public void test1() {

		User user = userService.findUser(2);

		System.out.println(user.toString());

	}

	@Test
	public void test2() {

		List<Permission> permission = permissionMapper.findPermission(2);
		System.out.println(permission.toString());

	}

	/**
	 * 测试返回结果作为map返回
	 */
	@Test
	public void test3() {

		Map<String, Object> map = userService.findUserMap(2);
		System.out.println(map.toString());

	}

}
