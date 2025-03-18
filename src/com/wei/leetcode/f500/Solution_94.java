package com.wei.leetcode.f500;

import com.wei.leetcode.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class Solution_94 {

    public static void main(String[] args) {
    }

    List<Integer> res = new ArrayList<>();

    public List<Integer> inorderTraversal(TreeNode root) {
        inorderTraversal2(root);
        return res;
    }

    public void inorderTraversal2(TreeNode root) {
        if (root == null) {
            return ;
        }
        inorderTraversal2(root.left);
        res.add(root.val);
        inorderTraversal2(root.right);
    }
}
