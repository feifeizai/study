package com.xhf.extend.service.impl;

import com.xhf.extend.service.HelloService;
import org.springframework.stereotype.Service;

/**
 * @author 谢红飞
 * description:
 * date 2020-5-21 20:30
 */
@Service
public class HelloServiceImpl1 implements HelloService {

    @Override
    public void sayHello() {
        System.out.println("你好我是HelloServiceImpl1");
    }

}
