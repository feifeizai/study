package com.xhf.extend.config;

import com.xhf.extend.annotation.RountingInjected;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanCreationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * @author 谢红飞
 * description:
 * date 2020-5-21 20:33
 */
@Component
public class HelloServiceInjectProcessor implements BeanPostProcessor {

    @Autowired
    private ApplicationContext applicationContext;

    //实例化Bean之前
    @Override
    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        return bean;
    }

    //实例化Bean之后
    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {

        Class<?> targetCls = bean.getClass();
        Field[] targetFld = targetCls.getDeclaredFields();
        for (Field field : targetFld) {
            if (field.isAnnotationPresent(RountingInjected.class)) {
                //获取字段类型
                if (!field.getType().isInterface()) {
                    throw new BeanCreationException("RoutingInjected field must be declared as an interface:" + field.getName()
                            + " @Class " + targetCls.getName());
                }
                try {
                    this.handleRoutingInjected(field, bean, field.getType());
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

        return null;
    }

    private void handleRoutingInjected(Field field, Object bean, Class type) throws IllegalAccessException {
        Map<String, Object> candidates = this.applicationContext.getBeansOfType(type);
        field.setAccessible(true);
        if (candidates.size() == 1) {
            field.set(bean, candidates.values().iterator().next());
        } else if (candidates.size() == 2) {
            String injectVal = field.getAnnotation(RountingInjected.class).value();
            Object proxy = RoutingBeanProxyFactory.createProxy(injectVal, type, candidates);
            field.set(bean, proxy);
        } else {
            throw new IllegalArgumentException("Find more than 2 beans for type: " + type);
        }
    }
}
