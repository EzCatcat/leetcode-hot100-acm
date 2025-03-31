package com.ezcatcat.oj.blbl0323;

import java.util.Random;
import java.util.Scanner;

/**
 * @Author: EzCatcat
 * @Date: 2025/3/23 19:27
 */
public class No2 {
    /**
     * 4 6 2
     * 可以这样分配1 2 2 1。可以小明分配到了2个苹果。
     * 要保证第k个位置，最大
     * - 如果 k == 1（0），后续是递减的
     *  4 6 1, 6/4=1, 2   2 2 1 1
     *  4 7 1, 7/4=1, 3   3 2 1 1
     *  m - n = 6 - 4 = 2, 在2个基础上，去分配 2个小于n，需要最多分1个
     *  7 - 4 = 3, 在3个基础上，去分配3个小于n，最多分3-1=2
     *  4 8 1   3 2 2 1
     *  4 9 1
     * - 如果 k == n，前面是递增的
     * - 如果 k 在中间，增 max 减
     *
     *
     * @param args
     */
    public static void main(String[] args) {
        /**
         * 如果先给第k个最大，向左右递减，可能-0 也可以-1，看是否满足条件
         * 最大可能 = m - n
         *
         */
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int k = in.nextInt();
        int ans = 0;
        int mMax = m - n;
        Random random = new Random();
        int x = random.nextInt(mMax) + k;
        System.out.println(x);
    }
    private static boolean dfs(int i) {
        if (i == 0) {
            return true;
        }
        // 当前操作
        return true;
    }
}
