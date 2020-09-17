package com.xhf.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * @author 谢红飞
 * date 2020-9-6
 */
@Component
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.TYPE})
public @interface ConfigModule {

    /**
     *  对应配置文件里面key为( MODULE_NAME ) 的值
     * @return
     */
    String value();
}
