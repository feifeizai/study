package com.xhf.test.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author 谢红飞
 * description:
 * date 2020-5-22 22:15
 */
public class JdkDynamic implements InvocationHandler {

    private Person person;

    public JdkDynamic() {
    }

    public JdkDynamic(Person person) {
        this.person = person;
    }

    public Person getInstance(Person person){
        this.person = person;
        Class<? extends Person> clazz = person.getClass();
        return (Person) Proxy.newProxyInstance(clazz.getClassLoader(),clazz.getInterfaces(),this);
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        eat();
        Object result = method.invoke(this.person, args);
        return result;
    }

    private void eat(){
        System.out.println("jdkDynamic eat");
    }
}
