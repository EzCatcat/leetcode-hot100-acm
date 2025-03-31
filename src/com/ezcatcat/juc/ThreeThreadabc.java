package com.ezcatcat.juc;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 线程1输出a5次，线程2输出b5次，线程3输出c5次。要求输出abcabcabcabcabc
 * @Author: EzCatcat
 * @Date: 2025/3/18 0:19
 */
public class ThreeThreadabc {

    public static void main(String[] args) {
       /* AwaitAndSignal awaitAndSignal = new AwaitAndSignal(5);
        Condition a = awaitAndSignal.newCondition();
        Condition b = awaitAndSignal.newCondition();
        Condition c = awaitAndSignal.newCondition();

        // a 不一定是最先执行的，可能会被其他线程 await
        new Thread(() -> {
            awaitAndSignal.print("a", a, b);
        }).start();
        new Thread(() -> {
            awaitAndSignal.print("b", b, c);
        }).start();
        new Thread(() -> {
            awaitAndSignal.print("c", c, a);
        }).start();

        awaitAndSignal.start(a);*/

        SyncWaitAndNotify syncWaitAndNotify = new SyncWaitAndNotify(5, 1);
        new Thread(() -> {
            syncWaitAndNotify.print(1, 2, "a");
        }).start();
        new Thread(() -> {
            syncWaitAndNotify.print(2, 3, "b");
        }).start();
        new Thread(() -> {
            syncWaitAndNotify.print(3, 1, "c");
        }).start();
    }

}

class SyncWaitAndNotify {
    private int loopNum;
    private int flag;

    public SyncWaitAndNotify(int loopNum, int flag) {
        this.loopNum = loopNum;
        this.flag = flag;
    }

    public void print(int cur, int next, String str) {
        for (int i = 0; i < loopNum; i++) {
            synchronized (this) {
                while (flag != cur) {
                    try {
                        this.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.print(str);
                flag = next;
                this.notifyAll();
            }
        }
    }
}



class AwaitAndSignal extends ReentrantLock{

    private int loopNum;

    public AwaitAndSignal(int loopNum) {
        this.loopNum = loopNum;
    }

    public void start(Condition first) {
        this.lock();
        try {
            first.signalAll();
        } finally {
            this.unlock();
        }
    }

    public void print(String str, Condition cur, Condition next) {
        for (int i = 0; i < loopNum; i++) {
            this.lock();
            try {
                System.out.print(str);
                cur.await();
                next.signalAll();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                this.unlock();
            }
        }
    }
}