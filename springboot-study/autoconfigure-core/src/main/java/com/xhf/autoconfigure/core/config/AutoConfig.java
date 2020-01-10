package com.xhf.autoconfigure.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author 谢红飞
 * @Title:
 * @Description:
 * @date 2020-1-10 22:21
 */
@Configuration
public class AutoConfig {

    @Bean
    public MyTemplate myTemplate(){
        return new MyTemplate();
    }
}
