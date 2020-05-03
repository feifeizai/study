package com.xhf.gupao.pubsub;

import redis.clients.jedis.Jedis;

/**
 * @Author: qingshan
 * @Date: 2019/9/27 10:54
 * @Description: 咕泡学院，只为更好的你
 */
public class ListenTest {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.31.168", 6379);
        final MyListener listener = new MyListener();
        // 使用模式匹配的方式设置频道
        // 会阻塞
        jedis.psubscribe(listener, new String[]{"qingshan-*"});
    }
}
