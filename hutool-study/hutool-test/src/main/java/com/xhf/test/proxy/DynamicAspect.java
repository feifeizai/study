package com.xhf.test.proxy;

import cn.hutool.aop.aspects.Aspect;

import java.lang.reflect.Method;

/**
 * @author 谢红飞
 * description:
 * date 2020-5-22 22:44
 */
public class DynamicAspect implements Aspect {
    @Override
    public boolean before(Object target, Method method, Object[] args) {
        System.out.println("DynamicAspect before");
        return true;
    }

    @Override
    public boolean after(Object target, Method method, Object[] args, Object returnVal) {
        System.out.println("DynamicAspect after");
        return true;
    }

    @Override
    public boolean afterException(Object target, Method method, Object[] args, Throwable e) {
        return false;
    }
}
