package com.ezcatcat.oj.pdd0308;

import java.util.Scanner;

/**
 * https://codefun2000.com/p/P2672
 * 传送门：从任意位置使用
 * @Author: EzCatcat
 * @Date: 2025/3/9 14:32
 */
public class No1 {
    /**
     * 一开始以为是dp问题，用dfs做有不对，没想到这是数学问题。。。
     * ----------------------------------------------------
     * 将数分为正数和负数，正数累加，负数累加用反转，就是答案
     * 其实求所有数的 abs 即可
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += Math.abs(in.nextInt());
        }
        System.out.println(ans);
    }
}


/*public class Main {
    private static int ans = 0;
    private static boolean[] op;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int[] nums = new int[n];
        op = new boolean[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        dfs(0, 0, false, n, nums);
        System.out.println(ans);
    }
    public static void dfs(int i, int x, boolean used, int n, int[] nums) {
        if (i == n) {
            ans = Math.max(ans, Math.abs(x));
            return;
        }
        for (int j = 0; j < n; j++) {
            if (!op[j]) {
                op[j] = true;

                // 不用翻转
                dfs(i+1, x + nums[j], used, n, nums);

                // 使用反转
                if (!used) {
                    dfs(i + 1, x + nums[j] * (-1), true, n, nums);
                }

                op[j] = false;
            }
        }
    }
}*/
