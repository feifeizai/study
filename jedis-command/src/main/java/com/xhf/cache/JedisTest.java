package com.xhf.cache;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import redis.clients.jedis.BinaryClient;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * @author 谢红飞
 * @Title:
 * @Description:
 * @date 2019-10-19 11:43
 */
public class JedisTest {

    Jedis jedis;
    JedisPool pool;

    @Before
    public void init() {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxIdle(8);
        config.setMaxTotal(18);
        pool = new JedisPool(config, "127.0.0.1", 6379, 2000);
        jedis = pool.getResource();
    }

    @After
    public void destroy() {
        jedis.close();
        pool.close();
    }

    @Test
    public void strTest() {
        jedis.set("key", "value");
        System.out.println("key:" + jedis.get("key"));
        //todo setnx和set的区别, setnx如果已经存在key,就不做任何操作
        jedis.setnx("key", "value2");
        System.out.println("key:" + jedis.get("key"));
        jedis.setnx("key2", "value2");
        System.out.println("key2:" + jedis.get("key2"));
        //todo 对value值添加,字符串拼接
        jedis.append("key2", "value-append");
        System.out.println("key2:" + jedis.get("key2"));
        //todo 清空redis数据
        jedis.flushDB();
    }

    /**
     * hset, hmset
     * hget, hgetAll, hmget
     * hkeys, hvals
     * hincrBy
     * hdel
     */
    @Test
    public void hashTest() {
        //todo 保存map数据
        jedis.hset("mkey", "name", "xhf");
        Map<String, String> map = new HashMap<String, String>();
        map.put("addr", "苏州");
        map.put("age", "25");
        //todo 直接保存map
        jedis.hmset("mkey", map);

        System.out.println("name: " + jedis.hget("mkey", "name"));
        System.out.println("name,age: " + jedis.hmget("mkey", "name", "age"));

        System.out.println("mmap: " + jedis.hgetAll("mkey"));
        //对value值增加
        jedis.hincrBy("mkey: ", "age", 1);
        System.out.println("age: " + jedis.hget("mkey", "age"));
        //mkey包含的所有的key
        System.out.println("mkey包含所有keys: " + jedis.hkeys("mkey"));
        //mkey包含的所有的vals
        System.out.println("mkey包含所有values: " + jedis.hvals("mkey"));
        //删除mkey下的name
        jedis.hdel("mkey", "name");
        System.out.println("mmap: " + jedis.hgetAll("mkey"));
        //删除mkey下的所有
        jedis.del("mkey");
        System.out.println("mmap: " + jedis.hgetAll("mkey"));

        jedis.flushDB();

    }

    /**
     * lpush(从插入左边), rpush(从右边插入)
     * lrange获取列表指定范围内的元素eg:(0 -1:查看所有, 0 3查看前4个)
     * lop左边弹出一个 相当于移除第一个
     * rpop右边弹出一个  相当于移除最后一个
     * lrem:
     * count > 0 : 从表头开始向表尾搜索，移除与 value 相等的元素，数量为 count 。
     * count < 0 : 从表尾开始向表头搜索，移除与 value 相等的元素，数量为 count 的绝对值。
     * count = 0 : 移除表中所有与 value 相等的值。
     * lset key index value通过索引设置列表元素的值(0代表第一个元素, 1代表第二个,-1代表尾元素),
     * linsert key before|after pivot value在从左到右第一个pivot元素前或者元素后插入一个值
     */
    @Test
    public void listTest() {
        jedis.lpush("lkey", "v5", "v1", "v2");
        jedis.lpush("lkey", "v3", "v2");
        jedis.rpush("lkey", "v4", "v6", "v2", "v7");
        //list:[v3, v2, v1, v5, v4]
        System.out.println("list:" + jedis.lrange("lkey", 0, -1));

        jedis.rpop("lkey");
        System.out.println("list:" + jedis.lrange("lkey", 0, -1));

        System.out.println("list长度:" + jedis.llen("lkey"));

        jedis.lrem("lkey", -1, "v2");
        System.out.println("list:" + jedis.lrange("lkey", 0, -1));

        jedis.lset("lkey", 1, "v8");
        System.out.println("list:" + jedis.lrange("lkey", 0, -1));

        jedis.linsert("lkey", BinaryClient.LIST_POSITION.AFTER, "v2", "v9");
        System.out.println("list:" + jedis.lrange("lkey", 0, -1));

        jedis.flushDB();

    }

    /**
     * 无序,唯一
     * sadd key member1 member2添加元素
     * smembers key返回集合中的所有成员,查看所有
     * sismember key member判断一个set中是否有指定的member
     * srem key member1 [member2]移除一个成员或者多个成员
     * sdiff key1 key2返回key1独有的集合
     * sunion key1 key2返回给定集合的并集
     * sinter key1 key2返回给定集合的交集
     * scard key获得set中成员的数量
     * srandmember key随机返回set的一个成员
     * sdiffstore key1  key2 key3将差异的部分插入key1
     * sunionstorekey1  key2 key3将并集的部分插入key1
     */
    @Test
    public void setTest() {
        jedis.sadd("skey", "sv1", "sv2","sv0");
        System.out.println("skey中所有值:" + jedis.smembers("skey"));
        System.out.println("skey中是否包含sv1:"+jedis.sismember("skey","sv1"));

        jedis.srem("skey","sv0");
        System.out.println("skey中所有值:" + jedis.smembers("skey"));

        jedis.sadd("skey1","sv1","sv3");
        Set<String> sdiff = jedis.sdiff("skey", "skey1");
        System.out.println("skey和skey1的不同:"+sdiff);

        Set<String> sunion = jedis.sunion("skey", "skey1");
        System.out.println("skey和skey1的并集:"+sunion);

        Set<String> sinter = jedis.sinter("skey", "skey1");
        System.out.println("skey和skey1的交集:"+sinter);

        jedis.sunionstore("skeyunion","skey","skey1");

        jedis.flushDB();
    }

    /**
     * redis正是通过分数来为集合中的成员进行从小到大的排序
     * 唯一(成员不可以重复)+有序(按照分数大小进行排序的)
     * zadd key score1 member1[ score2 member2]添加一个或者多个
     * zadd key Map<String,Double>
     * zcard key获得集合成员数量
     * zscore key member获取元素的得分
     * zrem key member1[member2]删除一个或者多个成员
     * zrange key startindex endindex [withscores] 按照分数的从小到大的顺序展示所有的元素
     * zrevrange key start stop [withscores] 按照分数的从大到小的顺序展示所有的元素
     */
    @Test
    public void zsetTest(){
        jedis.zadd("zkey",1.0,"v1");
        Map<String, Double> map = new HashMap<String, Double>();
        map.put("v2",2.0);
        map.put("v3",3.0);
        map.put("v4",1.0);
        map.put("v5",0.0);
        jedis.zadd("zkey",map);

        System.out.println("zkey所有的值:"+jedis.zrange("zkey",0,-1));

        System.out.println("v2的得分:"+jedis.zscore("zkey","v2"));

        jedis.zrem("zkey","v3");
        System.out.println("zkey所有的值:"+jedis.zrange("zkey",0,-1));

        System.out.println("zkey所有的值从大到小:"+jedis.zrevrange("zkey",0,-1));

    }
}
