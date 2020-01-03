package com.xhf.log.consumer.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author 谢红飞
 * @Description:
 * @date 2019-12-29 21:36
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private ConsumerHandlerInterceptor consumerHandlerInterceptor;

    public void addInterceptors(InterceptorRegistry registry) {
        // 添加拦截器，配置拦截地址
        registry.addInterceptor(consumerHandlerInterceptor).addPathPatterns("/**");
    }

}
