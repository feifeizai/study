package com.xhf.extend.annotation;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * @author 谢红飞
 * description:
 * date 2020-5-21 20:32
 */
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface RountingInjected {
    String value() default "helloServiceImpl1";
}
