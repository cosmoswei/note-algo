package com.wei.leetcode.f500;

import com.wei.leetcode.TreeNode;

import java.util.HashSet;
import java.util.Set;

public class Solution_671 {

    public static void main(String[] args) {
    }

    Set<Integer> set = new HashSet<>();

    public int findSecondMinimumValue(TreeNode treeNode) {
        dfs(treeNode);
        if (set.size() < 2) {
            return -1;
        }

        int first = Integer.MAX_VALUE, second = Integer.MAX_VALUE;
        for (Integer i : set) {
            if (i <= first) {
                second = first;
                first = i;
            } else if (i <= second) {
                second = i;
            }
        }
        return second;
    }

    public void dfs(TreeNode treeNode) {
        if (null == treeNode) {
            return;
        }
        set.add(treeNode.val);
        dfs(treeNode.left);
        dfs(treeNode.right);
    }
}
