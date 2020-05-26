package com.xhf.extend;

import com.xhf.extend.annotation.RountingInjected;
import com.xhf.extend.service.HelloService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Component;

/**
 * @author 谢红飞
 * description:
 * date 2020-5-21 20:45
 */
@Component
public class HelloServiceTest {

    @RountingInjected(value = "helloServiceImpl2")
    private HelloService helloService;

    public void testSayHello() {
        helloService.sayHello();
    }

    public static void main(String[] args) {
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext("com.xhf.extend");
        HelloServiceTest helloServiceTest = applicationContext.getBean(HelloServiceTest.class);
        helloServiceTest.testSayHello();
    }
}
