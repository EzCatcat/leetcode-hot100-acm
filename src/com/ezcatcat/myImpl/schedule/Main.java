package com.ezcatcat.myImpl.schedule;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @Author: EzCatcat
 * @Date: 2025/3/31 14:25
 */
public class Main {
    public static void main(String[] args) throws InterruptedException {
        ScheduleService scheduleService = new ScheduleService();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("HH:mm:ss SSS");
        scheduleService.schedule(() -> {
            System.out.println(LocalDateTime.now().format(formatter) + " 100ms 执行一次");
        }, 100);
        Thread.sleep(1000);
        System.out.println("添加一个每200ms 执行一次的任务");
        scheduleService.schedule(() -> {
            System.out.println(LocalDateTime.now().format(formatter) + " 200ms 执行一次");
        }, 200);
    }
}
