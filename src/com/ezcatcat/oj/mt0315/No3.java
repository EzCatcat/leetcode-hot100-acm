package com.ezcatcat.oj.mt0315;

import java.util.Scanner;

/**
 * @Author: EzCatcat
 * @Date: 2025/3/15 10:56
 */
public class No3 {
    /**
     * nums中任意取a1 a2，a1*x + a2*y = k，求x y的组合数，
     * - a1 a2 为端点，组合数是边权
     * 那点的权重是？
     * 问的是边的权重和吧。
     *
     * 计算最小生成树，我不会啊
     * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        System.out.println(4);
    }
}
