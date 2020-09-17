package com.xhf.demo;

import org.junit.Test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author Administrator 2020-11-14 10:20
 */
public class ThreadPoolExecutorTest {

    /**
     * 任务拒绝处理器
     * ThreadPoolExecutor.AbortPolicy: 丢弃任务并抛出RejectedExecutionException异常。 (默认)
     * ThreadPoolExecutor.DiscardPolicy：也是丢弃任务，但是不抛出异常。
     * ThreadPoolExecutor.DiscardOldestPolicy：丢弃队列最前面的任务，然后重新尝试执行任务（重复此过程）
     * ThreadPoolExecutor.CallerRunsPolicy：如果添加到线程池失败，那么主线程会自己去执行该任务
     */
    @Test
    public void test1() throws InterruptedException {
        int count = 20;
        final CountDownLatch latch = new CountDownLatch(count);
        //线程池作为局部变量时需要shutDown
        ThreadPoolExecutor executorService = new ThreadPoolExecutor(1, 2, 1L, TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>(5),
//                new ThreadPoolExecutor.AbortPolicy()//丢弃任务并抛出RejectedExecutionException异常
//                new ThreadPoolExecutor.DiscardPolicy()//队列中可以放5个任务,线程同时处理2个,丢弃3个任务,导致countDownLatch始终无法归零
//                new ThreadPoolExecutor.DiscardOldestPolicy()//丢弃队列最前面的任务，然后重新尝试执行任务（重复此过程）
                new ThreadPoolExecutor.CallerRunsPolicy()//如果添加到线程池失败，那么主线程会自己去执行该任务
        );
        for (int i = 0; i < count; i++) {
            executorService.execute(() -> {
                try {
                    System.out.println("子线程" + Thread.currentThread().getName());
                    Thread.sleep(2000);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    latch.countDown();
                    System.out.println("latch:" + latch.getCount());
                }
            });
        }
        latch.await();
        Thread.sleep(2000);
        executorService.shutdown();
        System.out.println("线程池已经执行完毕");
    }

    /**
     * 验证allowCoreThreadTimeOut方法是否会自动回收所有线程
     * 如果allowCoreThreadTimeOut=true，核心线程在规定时间内会被回收。
     */
    @Test
    public void test2() throws InterruptedException {
        int count = 10;
        final CountDownLatch latch = new CountDownLatch(count);
        //线程池作为局部变量时需要shutDown, 将等待时间设置为1秒
        ThreadPoolExecutor executorService = new ThreadPoolExecutor(5, 5, 1L, TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>(5));
        //
        executorService.allowCoreThreadTimeOut(true);
        for (int i = 0; i < count; i++) {
            executorService.execute(() -> {
                try {
                    System.out.println("子线程" + Thread.currentThread().getName());
                    Thread.sleep(2000);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    latch.countDown();
                    System.out.println("latch:" + latch.getCount());
                }
            });
        }
        latch.await();
        //在此处workers=5
        Thread.sleep(2000);
        //在此处workers=0
        executorService.shutdown();
        System.out.println("线程池已经执行完毕");
    }

    /**
     * prestartAllCoreThreads: 初始化线程池时是可以预先创建线程的，初始化线程池后，再调用prestartAllCoreThreads()方法，即可预先创建corePoolSize数量的核心线程
     * prestartCoreThread(): 同样可以预先创建线程，只不过该方法只会与创建1条线程
     */
    @Test
    public void test3() throws InterruptedException {
        int count = 10;
        final CountDownLatch latch = new CountDownLatch(count);
        //线程池作为局部变量时需要shutDown, 将等待时间设置为1秒
        ThreadPoolExecutor executorService = new ThreadPoolExecutor(5, 5, 1L, TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>(5));
        //下边这行代码执行前workers=0, 执行完之后workers=5
//        executorService.prestartAllCoreThreads();
        //下边这行代码执行前workers=0, 执行完之后workers=1
        executorService.prestartCoreThread();
        executorService.allowCoreThreadTimeOut(true);
        for (int i = 0; i < count; i++) {
            executorService.execute(() -> {
                try {
                    System.out.println("子线程" + Thread.currentThread().getName());
                    Thread.sleep(2000);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    latch.countDown();
                    System.out.println("latch:" + latch.getCount());
                }
            });
        }
        latch.await();
        //在此处workers=5
        Thread.sleep(2000);
        //在此处workers=0
        executorService.shutdown();
        System.out.println("线程池已经执行完毕");
    }
}
