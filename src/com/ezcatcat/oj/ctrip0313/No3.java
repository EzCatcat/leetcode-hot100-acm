package com.ezcatcat.oj.ctrip0313;

import java.util.Scanner;

/**
 * 游游有一个长度为n的数组，每个数的权值为它的质因子个数。现在游游想要删除一段长度刚好为k的子数组，删除后需要使剩
 * 下的数的权值和最大。问这个权值和是多少？
 *
 * 每个数的权值是 质因子个数
 * k的子数组，要删除后权重和最大
 * = 求长度为k的子数组，权重和最小，问权重和
 * 固定大小滑动窗口，求min
 * @Author: EzCatcat
 * @Date: 2025/3/14 18:15
 */
public class No3 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] nums = new int[n];
        int[] qz = new int[n];
        int qzSum = 0;
        for (int i = 0; i < n; i++) {
            nums[i] = in.nextInt();
            qz[i] = getQZ(nums[i]);
            qzSum += qz[i];
        }
        int l = 0;
        int sum = 0;
        int ans = Integer.MAX_VALUE;
        for (int r = 0; r < n; r++) {
            // 1. 加入
            sum += qz[r];
            // 2. 移除
            while (r - l + 1 > k) {
                sum -= qz[l++];
            }
            // 3. 更新
            if (r - l + 1 == k) {
                ans = Math.min(ans, sum);
            }
        }
        System.out.println(qzSum - ans);
    }
    public static int getQZ(int n) {
        int res = 0;
        for (int i = 2; i <= n; i++) {
            if (n % i == 0) {
                res++;
                while (n % i == 0) {
                    n /= i;
                }
            }
        }
        return res;
    }
}
