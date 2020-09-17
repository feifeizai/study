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
@Target({ElementType.FIELD,ElementType.TYPE})
public @interface ConfValue {

    String value();

    String defaultValue();
}
