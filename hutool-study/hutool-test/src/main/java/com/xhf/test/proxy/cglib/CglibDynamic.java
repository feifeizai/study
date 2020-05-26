package com.xhf.test.proxy.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author 谢红飞
 * description:
 * date 2020-5-22 22:30
 */
public class CglibDynamic implements MethodInterceptor {

    public Phone getInstance(Class<?> clazz) {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(clazz);
        enhancer.setCallback(this);
        return (Phone) enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        call();
        return methodProxy.invokeSuper(o, objects);
    }

    private void call() {
        System.out.println("iPhone打电话");
    }
}
