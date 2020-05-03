package com.xhf.curator.demo;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.Stat;

/**
 * @author 谢红飞
 * @Title:
 * @Description:
 * @date 2020-2-9 16:24
 */
public class CuratorDemo {

    private static String CONNECTION_STR =
            "127.0.0.1:2181";
    //"192.168.93.136:2181,192.168.93.136:2182,192.168.93.136:2183";

    public static void main(String[] args) throws Exception {
        CuratorFramework curatorFramework = CuratorFrameworkFactory.builder()
                .connectString(CONNECTION_STR)
                .sessionTimeoutMs(5000)
                .retryPolicy(new ExponentialBackoffRetry(1000, 3))
                .build();
        //ExponentialBackoffRetry
        //RetryOneTime  仅仅只重试一次
        //RetryUntilElapsed 一直重试直到时间结束
        //RetryNTimes //最大重试次数

        curatorFramework.start();

        //crud
        //curatorFramework.create();
        //curatorFramework.setData();
        //curatorFramework.delete();
        //curatorFramework.getData();

        createData(curatorFramework);
        updateData(curatorFramework);
        deleteData(curatorFramework);
    }

    private static void createData(CuratorFramework curatorFramework) throws Exception {
        curatorFramework.create().creatingParentsIfNeeded().withMode(CreateMode.PERSISTENT).
                forPath("/data/program", "test".getBytes());
    }

    private static void updateData(CuratorFramework curatorFramework) throws Exception {
        curatorFramework.setData().forPath("/data/program", "up".getBytes());

    }

    private static void deleteData(CuratorFramework curatorFramework) throws Exception {
        Stat stat=new Stat();
        String value=new String(curatorFramework.getData().storingStatIn(stat).forPath("/data/program"));
        curatorFramework.delete().withVersion(stat.getVersion()).forPath("/data/program");
    }
}
