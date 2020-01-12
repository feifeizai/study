package com.xhf.an.bean;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author 谢红飞
 * @Title:
 * @Description:
 * @date 2020-1-12 18:01
 */
@Import({Bean1.class, BeanConfig.class, BeanImportSelector.class, TestImportBeanDefinitionRegistrar.class})
@Configuration
public class AppConfig {

}
