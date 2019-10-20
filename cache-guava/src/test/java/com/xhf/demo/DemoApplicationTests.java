package com.xhf.demo;

import com.xhf.demo.cache.UserCache;
import com.xhf.demo.entity.User;
import com.xhf.demo.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.Assert;

import java.util.List;
import java.util.concurrent.ExecutionException;

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
	UserCache userCache;

	@Test
	public void guavaTest1() throws ExecutionException {

		User user = userCache.getUser(7);
		User user22 = userCache.getUser(7);
		User user23 = userCache.getUser(23);

		System.out.println("guavaTest1:"+user.toString());
	}

	@Test
	public void guavaTest2() throws ExecutionException {

		List<User> users = userCache.getAllUsers();
		System.out.println("guavaTest2:"+users.toString());
	}

}
