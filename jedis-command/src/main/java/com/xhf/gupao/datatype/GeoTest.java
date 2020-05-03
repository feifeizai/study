package com.xhf.gupao.datatype;

import redis.clients.jedis.GeoCoordinate;
import redis.clients.jedis.Jedis;

import java.util.HashMap;
import java.util.Map;

/**
 * @author 谢红飞
 * description:
 * date 2020-5-1 22:15
 */
public class GeoTest {

    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.31.168", 6379);
        Map<String, GeoCoordinate> geoMap = new HashMap<String, GeoCoordinate>();
        GeoCoordinate coordinate = new GeoCoordinate(112.899, 28.38);
        geoMap.put("gupao", coordinate);
        jedis.geoadd("positions", geoMap);
        System.out.println(jedis.geopos("positions", "gupao"));
        jedis.close();
    }
}
