package com.xhf.format.starter.autoconfigure;

import com.xhf.format.starter.format.FastJsonFormatProcessor;
import com.xhf.format.starter.format.FormatProcessor;
import com.xhf.format.starter.format.StringFormatProcessor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * @author 谢红飞
 * @Title:
 * @Description:
 * @date 2020-1-12 21:18
 */
@Configuration
public class FormatAutoConfiguration {

    @Bean
    @Primary
    @ConditionalOnMissingClass(value = "com.alibaba.fastjson.JSON")
    public FormatProcessor stringFormatProcessor() {
        return new StringFormatProcessor();
    }

    @Bean
    @ConditionalOnClass(name = "com.alibaba.fastjson.JSON")
    public FormatProcessor fastJsonFormatProcessor() {
        return new FastJsonFormatProcessor();
    }

}
