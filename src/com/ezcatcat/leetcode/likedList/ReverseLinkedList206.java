package com.ezcatcat.leetcode.likedList;

import java.util.Scanner;

/**
 * @Author: EzCatcat
 * @Date: 2025/3/6 15:37
 */
public class ReverseLinkedList206 {

    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args) {
        ListNode head = input();
        ListNode reverse = reverse(head);
        output(reverse);
    }
    private static ListNode reverse(ListNode head) {
        ListNode cur = head;
        ListNode pre = null, next;
        while (cur != null) {
            next =cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    /**
     * 输入：head = 1,2,3,4,5
     * @return
     */
    private static ListNode input() {
        Scanner in = new Scanner(System.in);
        String[] ss = in.nextLine().split(",");

        ListNode dummy = new ListNode();
        ListNode cur = dummy;

        for (String s : ss) {
            int val = Integer.parseInt(s);
            cur.next = new ListNode(val);
            cur = cur.next;
        }

        return dummy.next;
    }

    private static void output(ListNode head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }
}
