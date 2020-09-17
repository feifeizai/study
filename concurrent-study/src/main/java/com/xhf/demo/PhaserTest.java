package com.xhf.demo;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Phaser;

/**
 * @author 谢红飞
 * description:
 * date 2020-8-14 21:26
 */
public class PhaserTest {

    /*public static void main(String[] args) {
        CyclicBarrier cb = new CyclicBarrier(3);
        Thread t1 = new Thread(() -> process(cb), "T1");
        Thread t2 = new Thread(() -> process(cb), "T2");
        Thread t3 = new Thread(() -> process(cb), "T3");
        t1.start();
        t2.start();
        t3.start();
    }

    private static void process(CyclicBarrier cb) {
        try {
            System.out.println("Started Phase 1: "+Thread.currentThread().getName());
            cb.await();
            System.out.println("Finished Phase 1: "+Thread.currentThread().getName());
            System.out.println("Started Phase 2: "+Thread.currentThread().getName());
            cb.await();
            System.out.println("Finished Phase 2: "+Thread.currentThread().getName());
        } catch(Exception e) {}
    }*/

    public static void main(String[] args) {
        Phaser p = new Phaser(3);
        Thread t1 = new Thread(() -> process(p), "T1");
        Thread t2 = new Thread(() -> process(p), "T2");
        Thread t3 = new Thread(() -> process(p), "T3");
        t1.start();
        t2.start();
        t3.start();
    }

    private static void process(Phaser p) {
        try {
            System.out.println("Started Phase 1: "+Thread.currentThread().getName());
            p.arriveAndAwaitAdvance();
            System.out.println("Finished Phase 1: "+Thread.currentThread().getName());
            System.out.println("Started Phase 2: "+Thread.currentThread().getName());
            p.arriveAndAwaitAdvance();
            System.out.println("Finished Phase 2: "+Thread.currentThread().getName());
        } catch(Exception e) {}
    }


    
}
