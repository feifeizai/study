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
public @interface ConfGroup {

    String dataId();

    String group() default "DEFAULT_GROUP";

    String prefix() default "";

}
