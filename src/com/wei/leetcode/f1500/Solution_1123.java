package com.wei.leetcode.f1500;

import com.wei.leetcode.TreeNode;

public class Solution_1123 {

    public static void main(String[] args) {
        Solution_1123 solution = new Solution_1123();
        System.out.println("solution = "
                + solution.lcaDeepestLeaves(new TreeNode(1)).val);
    }

    private TreeNode res;
    private int maxDepth;

    public TreeNode lcaDeepestLeaves(TreeNode root) {
        dfs(root, 0);
        return res;
    }

    public int dfs(TreeNode root, int dept) {
        if (root == null) {
            maxDepth = Math.max(maxDepth, dept);
            return dept;
        }
        int left = dfs(root.left, dept + 1);
        int right = dfs(root.right, dept + 1);
        if (left == right && left == maxDepth) {
            res = root;
        }
        return Math.max(left, right);
    }

}
