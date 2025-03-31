package com.ezcatcat.oj.homeworkHelp0327;

import java.util.Arrays;
import java.util.Scanner;

/**
 * 给定一个数组nums，找三个数，使得乘积最大，返回乘积
 * -10,-5,2,3
 * 是不是可以先排序。从abs中选择
 * - 负数2，正数1
 * - 正数3
 * - 负数3
 * - 0？
 * @Author: EzCatcat
 * @Date: 2025/3/27 20:30
 */
public class No2 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] line = in.nextLine().split(",");
        int n = line.length;
        int[] nums = new int[n];
        int idx = 0;
        for (String s : line){
            nums[idx++] = Integer.parseInt(s);
        }
        Arrays.sort(nums);
        int ans = 1;
        if (n == 3) {
            ans = nums[0] * nums[1] * nums[2];
            System.out.println(ans);
            return;
        }
        int zeroIdx = indexOf(nums, n, 0);
        if (zeroIdx == 0 || zeroIdx == 1) {
            ans = nums[n - 1] * nums[n - 2] * nums[n - 3];
            System.out.println(ans);
            return;
        }
        /**
         * 有0的情况
         * - 0 1 2
         * - 0 1 2 3
         * - -1 0 1 2 ：如果其他3个，奇数个负数，后面也是负数，返回0
         * - -2 -1 0 1 ： 其他，偶个负数，求2个负数1个正数 or 3个正数
         */
        ans = Math.max(nums[0] * nums[1] * nums[n - 1], nums[n - 1] * nums[n - 2] * nums[n - 3]);
        System.out.println(ans);
    }

    private static int indexOf(int[] nums, int n, int x) {
        for (int i = 0; i < n; i++) {
            if (nums[i] == x) {
                return i;
            } else if(nums[i] > x) {
                return -1;
            }
        }
        return -1;
    }
}
