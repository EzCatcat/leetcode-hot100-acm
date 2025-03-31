package com.ezcatcat.juc;

import java.util.concurrent.locks.LockSupport;

/**
 * 两个线程交替打印01
 * @Author: EzCatcat
 * @Date: 2025/3/18 15:26
 */
public class TwoThread01 {
    public static void main(String[] args) {
        MySync mySync = new MySync();
        Thread t0 = new Thread(() -> {
            mySync.print(0, 1, 0);
        }, "t0");
        Thread t1 = new Thread(() -> {
            mySync.print(1, 0, 1);
        }, "t1");
        t0.start();
        t1.start();
    }
}
class MySync {
    private int flag = 0;
    public synchronized void print(int cur, int next, int num) {
       while (true) {
           while (flag != cur) {
               try {
                   this.wait();
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
           System.out.println(Thread.currentThread().getName() + ":" + num);
           flag = next;
           this.notifyAll();
       }
    }
}
