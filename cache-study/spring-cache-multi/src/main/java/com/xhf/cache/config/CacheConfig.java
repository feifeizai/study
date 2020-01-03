package com.xhf.cache.config;

import com.google.common.cache.CacheBuilder;
import org.springframework.cache.CacheManager;
import org.springframework.cache.guava.GuavaCache;
import org.springframework.cache.guava.GuavaCacheManager;
import org.springframework.cache.support.SimpleCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @author 谢红飞
 * @Title:
 * @Description:
 * @date 2019-12-20 23:40
 */
@Configuration
public class CacheConfig {

    @Bean
    public CacheManager secondManager() {
        GuavaCacheManager cacheManager = new GuavaCacheManager();
        cacheManager.setCacheBuilder(
                CacheBuilder.newBuilder().
                        expireAfterWrite(10, TimeUnit.SECONDS).
                        maximumSize(1000));

        return cacheManager;
    }


    /**
     * 默认使用这个注解
     */
    @Bean
    @Primary
    public CacheManager primaryManager() {
        GuavaCacheManager cacheManager = new GuavaCacheManager();
        cacheManager.setCacheBuilder(
                CacheBuilder.newBuilder().
                        expireAfterWrite(5, TimeUnit.SECONDS).
                        maximumSize(1000));
        return cacheManager;
    }


}
