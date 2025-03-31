package com.ezcatcat.juc;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.*;

/**
 * 多个参数，分批查询并聚合结果
 * @Author: EzCatcat
 * @Date: 2025/3/26 20:14
 */
public class CFSomeParams {

    private static ThreadPoolExecutor executor = new ThreadPoolExecutor(
            8,
            16,
            60,
            TimeUnit.SECONDS,
            new LinkedBlockingQueue<>(1024),
            new ThreadPoolExecutor.CallerRunsPolicy()
    );

    public static void main(String[] args) {
        List<String> params = new ArrayList<>(25);
        for (int i = 0; i < 25; i++) {
            params.add("param" + i);
        }
        List<String> res = batchProcess(params);
        res.forEach(System.out::println);
    }

    private static List<String> batchProcess(List<String> params) {
        List<List<String >> taskList = new ArrayList<>();
        for (int i = 0; i < params.size(); i += 10) {
            taskList.add(params.subList(i, Math.min(i + 10, params.size())));
        }
        // 把这些交给cf处理，并且每个任务都返回一个结果
        List<String> res = Collections.synchronizedList(new ArrayList<>());
        CountDownLatch latch = new CountDownLatch(taskList.size());
        for (List<String> task : taskList) {
            CompletableFuture.supplyAsync(() -> {
                // 处理
                StringBuilder sb = new StringBuilder();
                for (String s : task) {
                    sb.append(s);
                }
                return sb.toString();
            }).thenAccept(s -> {
                res.add(s);
                latch.countDown();
            });
        }
        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return res;
    }


}
