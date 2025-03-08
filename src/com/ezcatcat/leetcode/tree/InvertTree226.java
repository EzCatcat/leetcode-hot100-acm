package com.ezcatcat.leetcode.tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.Scanner;

/**
 * 226翻转二叉树
 * @Author: EzCatcat
 * @Date: 2025/3/8 14:51
 */
public class InvertTree226 {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode() {}
        TreeNode(int val) {
            this.val = val;
        }
        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        String[] nodes = input();
        TreeNode root = buildTree(nodes);
        System.out.println("=============原二叉树==============");
        bfs(root);
        TreeNode invertTree = invertTree(root);
        System.out.println("=============翻转后二叉树==============");
        bfs(invertTree);
    }

    /**
     * 翻转二叉树
     *  左右子树互相交换
     * @param root
     * @return
     */
    public static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }

    public static String[] input() {
        Scanner scanner = new Scanner(System.in);
        String[] nodes = scanner.nextLine().split(",");
        return nodes;
    }

    public static TreeNode buildTree(String[] nodes) {
        if (nodes == null || nodes.length == 0 || nodes[0].equals("null")) {
            return null;
        }
        Deque<TreeNode> q = new ArrayDeque<>();
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        q.add(root);
        // nodes 中遍历到的下标，从1开始，即从root的子树开始
        int index = 1;
        int n = nodes.length;
        while (!q.isEmpty() && index < n) {
            TreeNode cur = q.removeFirst();
            if (index < n && !nodes[index].equals("null")) {
                cur.left = new TreeNode(Integer.parseInt(nodes[index]));
                q.add(cur.left);
                index++;
            }
            if (index < n && !nodes[index].equals("null")) {
                cur.right = new TreeNode(Integer.parseInt(nodes[index]));
                q.add(cur.right);
                index++;
            }
        }
        return root;
    }

    public static void bfs(TreeNode root) {
        if (root == null) {
            return;
        }
        Deque<TreeNode> q = new ArrayDeque<>();
        q.add(root);
        while (!q.isEmpty()) {
            TreeNode cur = q.removeFirst();
            System.out.print(cur.val + " ");
            if (cur.left != null) {
                q.add(cur.left);
            }
            if (cur.right != null) {
                q.add(cur.right);
            }
        }
        System.out.println();
    }
}
