package com.xhf.utils;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

import java.lang.annotation.Annotation;
import java.util.Map;

/**
 * @author 谢红飞
 * date 2020-8-23 13:00
 */
@Component
public class SpringContextUtil implements ApplicationContextAware {

    // Spring应用上下文环境
    private static ApplicationContext applicationContext;

    /**
     * 实现ApplicationContextAware接口的回调方法，设置上下文环境
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        SpringContextUtil.applicationContext = applicationContext;
    }

    /**
     * 根据名称获取对象
     */
    public static Object getBean(String name) {
        return applicationContext.getBean(name);
    }

    /**
     * 根据类型获取
     */
    public static <T> T getBean(Class<T> clazz) {
        return applicationContext.getBean(clazz);
    }

    /**
     * 通过name,以及Clazz返回指定的Bean
     */
    public static <T> T getBean(String name, Class<T> clazz) {
        return applicationContext.getBean(name, clazz);
    }

    /**
     * 是否包含bean
     */
    public static boolean containsBean(String name) {
        return applicationContext.containsBean(name);
    }

    /**
     * 是否包含bean
     */
    public static boolean containsBean(Class clazz) {
        return applicationContext.containsBean(upperToLowerCamelCase(clazz.getSimpleName()));
    }

    private static String upperToLowerCamelCase(String upperCamelCase) {
        char[] cs = upperCamelCase.toCharArray();
        // 类名首字母小写
        cs[0] += 32;
        return String.valueOf(cs);
    }

    /**
     * 获取有给定注解的bean
     * key-beanName
     * value-bean
     */
    public static Map<String, Object> getBeansWithAnnotation(Class<? extends Annotation> annotationClz) {
        return applicationContext.getBeansWithAnnotation(annotationClz);
    }

}
