package com.ezcatcat.oj.ctrip0313;

import java.util.Scanner;

/**
 * @Author: EzCatcat
 * @Date: 2025/3/13 23:52
 */
public class No1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        output(in.nextLine());
    }
    private static void output(String s) {
        int line = 1;
        int n = s.length();
        int cur = 0;
        while (n >= line) {
            System.out.print(s.charAt(cur));
            cur += line;
            n -= line;
            line++;
        }
    }
}
