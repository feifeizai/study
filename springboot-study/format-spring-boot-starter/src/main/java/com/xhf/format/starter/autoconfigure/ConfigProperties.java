package com.xhf.format.starter.autoconfigure;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Map;

/**
 * @author 谢红飞
 * @Title:
 * @Description:
 * @date 2020-1-12 21:21
 */
@Data
@ConfigurationProperties(prefix = ConfigProperties.CONFIG_PREFIX)
public class ConfigProperties {

    public static final String CONFIG_PREFIX = "config";

    private Map<String,Object> info;

}
