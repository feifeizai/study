package com.xhf.an.bean;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 谢红飞
 * @Title:
 * @Description:
 * @date 2020-1-12 18:08
 */
@Configuration
public class BeanConfig {

    @Bean
    public Bean2 bean2(){
        return new Bean2();
    }
}
