package com.xhf.schedule.annotation;

import java.lang.annotation.*;

/**
 * @author 谢红飞
 * description:
 * date 2020-5-11 20:58
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CronScheduled {

    String cron() default "";

    String desc() default "";
}
