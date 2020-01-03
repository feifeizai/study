package com.xhf.cache.config;

import com.github.benmanes.caffeine.cache.Caffeine;
import org.springframework.cache.CacheManager;
import org.springframework.cache.caffeine.CaffeineCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.concurrent.TimeUnit;

/**
 * @author 谢红飞
 * @Title:
 * @Description:
 * @date 2019-12-24 21:35
 */
@Configuration
public class CaffeineConfiguration {

    @Bean
    public CacheManager caffeineCacheManager() {

        CaffeineCacheManager cacheManager = new CaffeineCacheManager();
        cacheManager.setCaffeine(Caffeine.newBuilder()
                .initialCapacity(300)
                .expireAfterWrite(5, TimeUnit.MINUTES)
                .maximumSize(2000));

        return cacheManager;
    }

}
