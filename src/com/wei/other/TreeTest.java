package com.wei.other;

import com.wei.leetcode.LeetCodeUtils;
import com.wei.leetcode.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class TreeTest {

    public static void main(String[] args) {
        int[] nums = {3, 9, 20, 00, 0, 15, 7};
        TreeNode treeNode = LeetCodeUtils.arrayToTree(nums);
        System.out.println(treeNode);
        traverse(treeNode);
    }

    /**
     * 前，中，后序遍历
     */
    static void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        traverse(root.left);
        traverse(root.right);
        System.out.print(root.val + " ");
    }

    /**
     * 层序遍历
     */
    static void levelOrderTraverse(TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        // 记录当前遍历到的层数（根节点视为第 1 层）
        int depth = 1;

        while (!q.isEmpty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                TreeNode cur = q.poll();
                // 访问 cur 节点，同时知道它所在的层数
                System.out.println("depth = " + depth + ", val = " + cur.val);

                // 把 cur 的左右子节点加入队列
                if (cur.left != null) {
                    q.offer(cur.left);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                }
            }
            depth++;
        }
    }

    /**
     * 层序遍历
     */
    static void levelTraverse(TreeNode root) {
        if (root == null) return;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while (!q.isEmpty()) {
            int sz = q.size();
            for (int i = 0; i < sz; i++) {
                TreeNode cur = q.poll();
                System.out.print(cur.val + " ");
                if (cur.left != null) {
                    q.offer(cur.left);
                }
                if (cur.right != null) {
                    q.offer(cur.right);
                }
            }
        }
    }
}
