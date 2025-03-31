package com.ezcatcat.oj.mt0315;

import java.util.Scanner;

/**
 * @Author: EzCatcat
 * @Date: 2025/3/15 10:29
 */
public class No2 {
    /**
     * 输入4个数，四种组合，求是否为倍数的个数
     * l1 l2
     * r1 l2
     * l1 r2
     * r1 r2
     * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int l1 = in.nextInt(); ;
        int r1 = in.nextInt();
        int l2 = in.nextInt();
        int r2 = in.nextInt();

        int ans = 0;

        for (int i = l1; i <= r1; i++) {
            for (int j = l2; j <= r2; j++) {
                if (i % j == 0) {
                    ans++;
                }
            }
        }

        System.out.println(ans);

    }
}
