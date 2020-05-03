package com.xhf.gupao.pubsub;

import redis.clients.jedis.Jedis;

/**
 * @Author: qingshan
 * @Date: 2019/9/27 10:55
 * @Description: 咕泡学院，只为更好的你
 */
public class PublishTest {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.31.168", 6379);
        jedis.publish("qingshan-123", "666");
        jedis.publish("qingshan-abc", "pengyuyan");
    }
}
