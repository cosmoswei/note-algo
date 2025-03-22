package com.wei.leetcode.f500;

import com.wei.leetcode.TreeNode;

public class Solution_100 {

    public static void main(String[] args) {
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null || q == null) {
            return p == q;
        }
        return q.val == p.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
