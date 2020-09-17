package com.xhf.demo;

import org.junit.internal.runners.statements.RunAfters;

import java.util.Arrays;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @author 谢红飞
 * description:
 * date 2020-7-27 22:23
 */
public class ScheduleTest {

    public static void main(String[] args) {
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(1);

        BlockingQueue<Runnable> list = new LinkedBlockingDeque<>();

        for (int i = 0; i < 5; i++) {
            list.add(new Task(i + ""));
        }

        ScheduledThreadPoolExecutor executor = new ScheduledThreadPoolExecutor(1);
        executor.scheduleWithFixedDelay(() -> {
            try {
                long endTime = System.currentTimeMillis() / 1000;
                System.out.println("time:" + endTime);
                System.out.println("执行任务");
                Runnable poll = list.poll();
                if (null != poll) {
                    poll.run();
                } else {
                    executor.shutdown();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, 1, 1, TimeUnit.SECONDS);

    }

    private static class TaskPool {

        private BlockingQueue<Runnable> queues;

        public TaskPool(BlockingQueue<Runnable> queues) {
            this.queues = queues;
        }
    }

    private static class Task implements Runnable {

        private String name;

        public Task() {
        }

        public Task(String name) {
            this.name = name;
        }

        @Override
        public void run() {
            System.out.println(new Date() + "---" + name);
        }
    }

}
