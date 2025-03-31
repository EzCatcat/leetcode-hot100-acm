package com.ezcatcat.oj.mt0308;

import java.util.Scanner;

/**
 * @Author: EzCatcat
 * @Date: 2025/3/14 19:51
 */
public class No1 {
    /**
     * 输入s，对s的每个字符进行不同的操作
     * - 数字x：
     *  - p == 0：p = x
     *  - p != 0：p = 10p + x
     * - 字母c：t 先左移 p 位，p=0
     *  - c == R：翻转 t
     *  - c != R：直接把 c 添到 t 后
     *
     * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        while (n-- > 0) {
            String s = in.nextLine();
            System.out.println(jm(s));
        }
    }
    public static String jm(String s) {
        char[] cs = s.toCharArray();
        StringBuilder t = new StringBuilder();
        int p = 0;
        for (char c : cs) {
            if (c >= '0' && c <= '9') {
                if (p == 0) {
                    p = c - '0';
                } else {
                    p = p * 10 + c - '0';
                }
            } else {
                t = leftMove(t, p);
                p = 0;
                if (c == 'R') {
                    t.reverse();
                } else {
                    t.append(c);
                }
            }
        }
        return t.toString();
    }
    public static StringBuilder leftMove(StringBuilder t, int p) {
        if (p == 0 || t.length() == 0) {
            return t;
        }
        int len = t.length();
        int shift = p % len;  // 关键修正：计算有效左移位数
        String right = t.substring(shift);
        String left = t.substring(0, shift);
        return new StringBuilder(right).append(left);
    }
}
