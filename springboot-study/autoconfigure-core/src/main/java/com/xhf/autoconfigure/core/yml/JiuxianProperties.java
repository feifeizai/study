package com.xhf.autoconfigure.core.yml;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

/**
 * @author 谢红飞
 * @Title:
 * @Description: yml文件中自动提示需要配置的属性
 * @date 2020-1-10 22:10
 */
@Data
@ConfigurationProperties(prefix = "jiuxian")
public class JiuxianProperties {
    private String name;
    private String nameCn;
    private String nameEn;
    private String[] hobbies;
    private SexEnum sexEnum;
    private boolean single;
    @NestedConfigurationProperty
    private School school;
    private City city;

    enum SexEnum {
        MAN, WOMAN
    }

    @Data
    static class City {
        private String no;
        private String name;
    }
}
