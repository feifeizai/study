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
public class GuavaCacheConfig {

    /**
     * 1.对所有的缓存生效
     * empservice
     * @return
     */
    /*@Bean
    public CacheManager cacheManager() {
        GuavaCacheManager cacheManager = new GuavaCacheManager();
        cacheManager.setCacheBuilder(
                CacheBuilder.newBuilder().
                        expireAfterWrite(10, TimeUnit.SECONDS).
                        maximumSize(1000));

        return cacheManager;
    }*/


    /**
     * 2.如果你想设置不同的size和过期时间的Cache，可以使用SimpleCacheManager，设置GuavaCache的List，
     * userservice
     * @return
     */
    @Bean
    public CacheManager cacheManager() {
        SimpleCacheManager manager = new SimpleCacheManager();
        List list = new ArrayList();

        list.add(new GuavaCache("userCacheOne", CacheBuilder.newBuilder().
                expireAfterWrite(10, TimeUnit.SECONDS).
                maximumSize(1000).build()));

        list.add(new GuavaCache("userCacheTwo", CacheBuilder.newBuilder().
                expireAfterWrite(5, TimeUnit.SECONDS).
                maximumSize(1000).build()));

        manager.setCaches(list);
        return manager;
    }


}
