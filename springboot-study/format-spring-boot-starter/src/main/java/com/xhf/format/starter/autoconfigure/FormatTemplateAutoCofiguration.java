package com.xhf.format.starter.autoconfigure;

import com.xhf.format.starter.FormatTemplate;
import com.xhf.format.starter.format.FormatProcessor;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author 谢红飞
 * @Title:
 * @Description:
 * @date 2020-1-12 21:40
 */
@Configuration
@Import(FormatAutoConfiguration.class)
@EnableConfigurationProperties(ConfigProperties.class)
public class FormatTemplateAutoCofiguration {

    @Bean
    public FormatTemplate formatTemplate(ConfigProperties helloProperties,
                                         FormatProcessor formatProcessor) {
        return new FormatTemplate(helloProperties, formatProcessor);
    }

}
