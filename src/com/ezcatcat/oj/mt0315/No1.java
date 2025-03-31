package com.ezcatcat.oj.mt0315;

import java.util.Scanner;

/**
 * @Author: EzCatcat
 * @Date: 2025/3/15 10:16
 */
public class No1 {
    /**
     * 大小写混合的字符串
     * 每个字符 c
     * - 非'R' 'Z'：添加到 t
     * - 'R'：反转
     * - 'Z'：撤销上一步
     *  - 非RZ添加：删去末尾
     *  - 为R：再翻转
     *  - 上一个字符没有：不操作
     * 所以需要遍历，并记录上一个字符
     * @param args
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        in.nextLine();
        while (n-- > 0) {
            String s = in.nextLine();
            StringBuilder t = new StringBuilder();
            char[] cs = s.toCharArray();
            char pre = ' ';
            for (int i = 0; i < cs.length; i++) {
                if (cs[i] == 'R') {
                    t.reverse();
                } else if (cs[i] == 'Z') {
                    if (pre == ' ') {
                        continue;
                    } else if (pre == 'R') {
                        t.reverse();
                    } else {
                        t.deleteCharAt(t.length() - 1);
                    }
                } else {
                    t.append(cs[i]);
                }
                pre = cs[i];
            }
            System.out.println(t.toString());
        }
    }
}
