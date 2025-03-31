package com.ezcatcat.oj.ctrip0313;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 这题难道不是求最小值吗？ 不对，求黑色中的最小值，但要结果尽可能大，所以黑色的值不能很小
 * 那加入黑色的标准是什么？就是大！那我们可以排序，从大的加，边加边看有没有 min+n 是更大的
 * nonono，不能加到一半break，万一后面还有？所以应该全部遍历
 * score = nums[i] + (n - i)
 * @Author: EzCatcat
 * @Date: 2025/3/14 0:00
 */
public class No2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        while (t-- > 0) {
            int n = in.nextInt();
            int[] nums = new int[n];
            for (int i = 0; i < n; i++) {
                nums[i] = in.nextInt();
            }
            Arrays.sort(nums);
            long ans = 0;
            for (int i = n - 1; i >= 0; i--) {
                ans = Math.max(ans, nums[i] + (n - i));
            }
            System.out.println(ans);
        }
    }
}
