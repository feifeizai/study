package com.xhf.test;

import cn.hutool.aop.ProxyUtil;
import com.xhf.test.proxy.DynamicAspect;
import com.xhf.test.proxy.cglib.CglibDynamic;
import com.xhf.test.proxy.cglib.Phone;
import com.xhf.test.proxy.jdk.JdkDynamic;
import com.xhf.test.proxy.jdk.Man;
import com.xhf.test.proxy.jdk.Person;
import org.junit.Test;

/**
 * @author 谢红飞
 * description:
 * date 2020-5-22 22:20
 */
public class ProxyTest {

    @Test
    public void test(){
        new JdkDynamic().getInstance(new Man()).eat();
    }

    @Test
    public void test1(){
        new CglibDynamic().getInstance(Phone.class).call();
    }

    @Test
    public void test2(){
        Man man = new Man();
        Person p = ProxyUtil.newProxyInstance(man.getClass().getClassLoader(), new JdkDynamic(man), Person.class);
        p.eat();
    }

    @Test
    public void test3(){
        Man proxy = ProxyUtil.proxy(new Man(), DynamicAspect.class);
        proxy.eat();
    }

}
