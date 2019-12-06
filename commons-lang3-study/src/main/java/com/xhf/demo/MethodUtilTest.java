package com.xhf.demo;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.reflect.MethodUtils;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @author 谢红飞
 * @Title:
 * @Description:
 * @date 2019-11-30 16:31
 */
public class MethodUtilTest {

    @Test
    public void methodTest() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        StringUtils stringUtils = new StringUtils();
        boolean isEmpty = (Boolean) MethodUtils.invokeMethod(stringUtils, "isEmpty", "");
        System.out.println("调用StringUtils.isEmpty()方法:" + isEmpty);

    }

    @Test
    public void methodTest1() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        User user = new User();

        String s = (String) MethodUtils.invokeMethod(user, "sayMethod", "你好");
        System.out.println("s:" + s);

        Integer age = (Integer) MethodUtils.invokeMethod(user,true,"ageMethod");
        System.out.println("age:" + age);

        boolean issleep = (Boolean) MethodUtils.invokeMethod(user,true,"sleepMethod");
        System.out.println("issleep:" + issleep);
    }

    @Test
    public void methodTest2() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException {

        User user = new User();
        //todo 必须要有getset方法
        String name = (String) PropertyUtils.getProperty(user,"name");
        System.out.println("name:"+name);
        Integer age1 = (Integer)PropertyUtils.getProperty(user, "age");
        System.out.println("age1:"+age1);

        PropertyUtils.setProperty(user,"name","xhf");
        //todo 将属性转化为map
        Map map = PropertyUtils.describe(user);
        System.out.println("name = " + map.get("name") + "  age = " + map.get("age"));

        String s = (String) MethodUtils.invokeMethod(user, "sayMethod", "你好");
        System.out.println("s:" + s);

        Integer age = (Integer) MethodUtils.invokeMethod(user,true,"ageMethod");
        System.out.println("age:" + age);

        boolean issleep = (Boolean) MethodUtils.invokeMethod(user,true,"sleepMethod");
        System.out.println("issleep:" + issleep);
    }

}
