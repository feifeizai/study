package com.xhf.lombok.entity;

import lombok.Synchronized;

/**
 * @author Administrator
 * @date 2020-10-02 15:37
 */
public class SynchronizeExample {

    @Synchronized
    public void print(){
        System.out.println("this is print");
    }

    @Synchronized
    public static void hello(){
        System.out.println("this is hello");
    }

    public static void main(String[] args) {
        hello();
    }

/*    private final Object $lock = new Object[0];
    private static final Object $LOCK = new Object[0];

    public SynchronizeExample() {
    }

    public void print() {
        synchronized(this.$lock) {
            System.out.println("this is print");
        }
    }

    public static void hello() {
        synchronized($LOCK) {
            System.out.println("this is hello");
        }
    }*/
}
