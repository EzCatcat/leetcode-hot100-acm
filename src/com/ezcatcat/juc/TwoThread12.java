package com.ezcatcat.juc;

import java.util.concurrent.locks.LockSupport;

/**
 * 两个线程，先打印2，再打印1
 * @Author: EzCatcat
 * @Date: 2025/3/18 0:18
 */
public class TwoThread12 {

    private static final Object lock = new Object();
    private volatile static boolean flag = false;

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            synchronized (lock) {
                while (!flag) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            System.out.println("1111111");
        }, "t1");

        Thread t2 = new Thread(() -> {
            synchronized (lock) {
                System.out.println("2222222");
                flag = true;
                lock.notifyAll();
            }

        }, "t2");

        t1.start();
        t2.start();
    }

    private void method1() {
        Thread t1 = new Thread(() -> {
            LockSupport.park();
            System.out.println("1111111");
        }, "t1");

        Thread t2 = new Thread(() -> {
            System.out.println("2222222");
            LockSupport.unpark(t1);
        }, "t2");

        t1.start();
        t2.start();
    }
}
