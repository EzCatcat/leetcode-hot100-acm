package com.ezcatcat.oj;

/**
 * 从 n 个数选 m 个数，要求概率一样
 * - 从 n 选：1 / n
 * - 从 n-1 选：1 / n-1   由于第一个没抽中：(n-1) / n   所以概率是 1 / n
 *
 * 所以，我们 i - n只需要抽一个随机数，和第 i 的下标交换顺序，抽取第 i 个数了
 * 然后，再从 i+1 - n 随机抽一个下标，和第 i+1 的下标交换，抽取第 i+1 个数
 *
 * @Author: EzCatcat
 * @Date: 2025/4/5 22:06
 */
public class NPickM {
    public static void main(String[] args) {
        int n = 5;
        int m = 3;
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = i + 1;
        }
        for (int i = 0; i < m; i++) {
            int random = (int)(Math.random() * (n - i)) + i;
            int temp = nums[i];
            nums[i] = nums[random];
            nums[random] = temp;
            System.out.println(nums[i] + " ");
        }
    }
}
