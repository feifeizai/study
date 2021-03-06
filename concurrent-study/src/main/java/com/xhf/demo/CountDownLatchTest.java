package com.xhf.demo;

import org.junit.Test;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author 谢红飞
 * description: 利用它可以实现类似计数器的功能。比如有一个任务A，它要等待其他4个任务执行完毕之后才能执行，此时就可以利用CountDownLatch来实现这种功能了。
 * date 2020-5-4 23:26
 */
public class CountDownLatchTest {

    public static void main(String[] args) {
        final CountDownLatch latch = new CountDownLatch(2);

        new Thread(() -> {
            try {
                System.out.println("子线程" + Thread.currentThread().getName() + "正在执行");
                Thread.sleep(3000);
                System.out.println("子线程" + Thread.currentThread().getName() + "执行完毕");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                latch.countDown();
            }
        }).start();

        new Thread(() -> {
            try {
                System.out.println("子线程" + Thread.currentThread().getName() + "正在执行");
                Thread.sleep(3000);
                System.out.println("子线程" + Thread.currentThread().getName() + "执行完毕");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                latch.countDown();
            }
        }).start();

        try {
            System.out.println("等待2个子线程执行完毕...");
            latch.await();
            System.out.println("2个子线程已经执行完毕");
            System.out.println("继续执行主线程");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test1() {
        final CountDownLatch latch = new CountDownLatch(2);

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        executorService.execute(() -> {
            try {
                System.out.println("子线程" + Thread.currentThread().getName() + "正在执行");
                Thread.sleep(3000);
                System.out.println("子线程" + Thread.currentThread().getName() + "执行完毕");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                latch.countDown();
            }
        });

        executorService.execute(() -> {
            try {
                System.out.println("子线程" + Thread.currentThread().getName() + "正在执行");
                Thread.sleep(3000);
                System.out.println("子线程" + Thread.currentThread().getName() + "执行完毕");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                latch.countDown();
            }
        });

        try {
            System.out.println("等待2个子线程执行完毕...");
            latch.await(2, TimeUnit.SECONDS);
            System.out.println("2个子线程已经执行完毕");
            System.out.println("继续执行主线程");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test2() throws InterruptedException {
        final CountDownLatch latch = new CountDownLatch(30);
        //线程池作为局部变量时需要shutDown
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 30; i++) {
            executorService.execute(() -> {
                try {
                    System.out.println("子线程" + Thread.currentThread().getName() + "正在执行");
                    Thread.sleep(3000);
                    System.out.println("子线程" + Thread.currentThread().getName() + "执行完毕");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    latch.countDown();
                }
            });
        }
        System.out.println("等待2个子线程执行完毕...");
        latch.await();
        executorService.shutdown();
        System.out.println("2个子线程已经执行完毕");

    }

    @Test
    public void test3() throws InterruptedException {
        int count = 10;
        final CountDownLatch latch = new CountDownLatch(count);
        //线程池作为局部变量时需要shutDown
        ThreadPoolExecutor executorService = new ThreadPoolExecutor(5, 5, 60L, TimeUnit.SECONDS,
                new LinkedBlockingQueue<Runnable>(5));
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
        executorService.shutdown();
        System.out.println("线程池已经执行完毕");
    }


}
