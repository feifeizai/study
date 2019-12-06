package com.xhf.mybatis.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * @author 谢红飞
 * @Title:
 * @Package
 * @Description:
 * @date 2019-4-22 21:55
 */
@Configuration
public class DatasourceConfig {

    @ConfigurationProperties(prefix = "spring.datasource")
    @Bean
    public DataSource druid(){
        return  new HikariDataSource();
    }
}
