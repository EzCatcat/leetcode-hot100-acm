package com.ezcatcat.juc;

import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.LongAdder;

/**
 * 三个线程，交替打印1-100
 * @Author: EzCatcat
 * @Date: 2025/3/18 0:19
 */
public class ThreeThread1to100 {
    public static void main(String[] args) {

        AtomicInteger atomicInteger = new AtomicInteger(0);
        Sync sync = new Sync(1, 100);
        new Thread(() -> {
            sync.print(1, 2, atomicInteger);
        }, "t1").start();

        new Thread(() -> {
            sync.print(2, 3, atomicInteger);
        }, "t2").start();

        new Thread(() -> {
            sync.print(3, 1, atomicInteger);
        }, "t3").start();

    }
}
class Sync {
    // 期待的线程
    private int flag;
    private int max;

    public Sync(int flag, int max) {
        this.flag = flag;
        this.max = max;
    }

    public synchronized void print(int cur, int next, AtomicInteger atomicInteger) {
        while (atomicInteger.get() < max) {
            // 需要对当前数判断，防止达到100后前面线程被唤醒，发现flag不匹配而进行死等，所以需要对atomicInteger进行判断
            // eg. 1 3 线程来了，1打印完100, 3被唤醒，但3不匹配flag会死等（如果加了atomicInteger判断就退出了）
            while (flag != cur && atomicInteger.get() < max) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            if (atomicInteger.get() < max) {
                System.out.println(Thread.currentThread().getName() + ":" + atomicInteger.incrementAndGet());
                flag = next;
                this.notifyAll();
            }
        }
    }
}
