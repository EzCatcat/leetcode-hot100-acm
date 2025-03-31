package com.ezcatcat.myImpl.schedule;

import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.locks.LockSupport;

/**
 * 定时任务服务
 * @Author: EzCatcat
 * @Date: 2025/3/31 14:25
 */
public class ScheduleService {

    ExecutorService executorService = Executors.newFixedThreadPool(6);

    Trigger trigger = new Trigger();

    public void schedule(Runnable task, long delay) {
        Job job = new Job();
        job.setTask(task);
        job.setStartTime(System.currentTimeMillis() + delay);
        job.setDelay(delay);

        trigger.queue.offer(job);
        trigger.wakeUp();
    }

    /**
     * 触发器，对Job进行调度，在合适的时间放入线程池
     */
    public class Trigger {

        public PriorityBlockingQueue<Job> queue = new PriorityBlockingQueue<>();

        Thread thread = new Thread(() -> {
            while (true) {
                while (queue.isEmpty()) {
                    LockSupport.park();
                }
                Job firstJob = queue.peek();
                if (firstJob != null && System.currentTimeMillis() >= firstJob.getStartTime()) {
                    // 执行，并计算下一次触发时间
                    firstJob = queue.poll();
                    executorService.submit(firstJob.getTask());
                    Job nextJob = new Job();
                    nextJob.setTask(firstJob.getTask());
                    nextJob.setStartTime(System.currentTimeMillis() + firstJob.getDelay());
                    nextJob.setDelay(firstJob.getDelay());
                    queue.offer(nextJob);
                } else {
                    LockSupport.parkUntil(firstJob.getStartTime());
                }
            }
        });

        {
            thread.start();
        }

        /**
         * 当有新任务，就要唤醒等待中的线程，判断有没有更先执行的任务
         */
        public void wakeUp() {
            LockSupport.unpark(thread);
        }
    }
}
