package com.ezcatcat.oj.blbl0323;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 把数组分为k个不相交的非空子序列，使子序列的极差之和尽可能大，求最大的极差之和
 * @Author: EzCatcat
 * @Date: 2025/3/23 19:14
 */
public class No1 {
    /**
     * {1,5},{2,4},{3}，极差之和为4+2+0=6
     * 1 2 3 4 5：5-1=4，4-2=2，3-0=3 排序后？
     * 拿 nums[n-i] nums[i] 相减，就能得到极差：最大值-最小值
     * 减k次，之和就是答案
     * 1 2 3 ，k=3 --> {1} {2} {3} --> 只有一个，极差为0
     * 那n k 怎么分？
     * - 如果 n == k 极差0
     * - 1 2 3 4, k = 3 --> {1, 4} {2} {3}
     * 应该是边算边减，如果 n 减少到 == k，就停止
     * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        in.nextLine();
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
        }
        Arrays.sort(nums);
        long ans = 0;
        int l = 0;
        int r = n;
        while (k != r) {
            ans += nums[n - 1 - l] - nums[l];
            r--;
            l++;
        }
        System.out.println(ans);
    }
}
