package com.ezcatcat.oj.homeworkHelp0327;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @Author: EzCatcat
 * @Date: 2025/3/27 20:46
 */
public class N03 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] line = in.nextLine().split(" ");
        int n = Integer.parseInt(line[0]);
        int q = Integer.parseInt(line[1]);
        line = in.nextLine().split(" ");
        int[] nums = new int[n];
        for (int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(line[i]);
        }
        int idx = 0;
        Set<Integer> set = new HashSet<>();
        while (q-- > 0) {
            set.clear();
            line = in.nextLine().split(" ");
            char c = line[0].charAt(0);
            int x = Integer.parseInt(line[1]);
            if (c == 'L') {
                for (int i = 0; i < x; i++) {
                //    System.out.println("testL: " + nums[(idx + i) % n]);
                    set.add(nums[(idx + i) % n]);
                }
                idx += x;
            } else {
                int cr = idx;
                for (int i = 0; i < x; i++) {
                    cr = idx - i;
                    if (cr < 0) cr = n + cr;
                  //  System.out.println("testR: " + (cr) % n + " val:"+ nums[cr % n]);
                    set.add(nums[cr % n]);
                }
                idx = cr - 1;
               // System.out.println("end: " + idx);
            }
            System.out.println(set.size());
        }
    }
}
