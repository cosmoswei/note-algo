package com.wei.leetcode.f500;

import com.wei.leetcode.TreeNode;

import java.util.HashMap;
import java.util.Map;

public class Solution_437 {

    public static void main(String[] args) {
        Solution_437 solution = new Solution_437();
        int res = solution.pathSum(new TreeNode(-1), 7);
        System.out.println("res = " + res);
    }


    private int res = 0;

    public int pathSum(TreeNode root, int targetSum) {
        Map<Long, Integer> map = new HashMap<>();
        map.put(0L, 1);
        dfs(root, 0, targetSum, map);
        return res;
    }

    private void dfs(TreeNode root, long s, int targetSum, Map<Long, Integer> map) {
        if (root == null) {
            return;
        }
        s += root.val;
        res += map.getOrDefault(s - targetSum, 0);
        map.merge(s, 1, Integer::sum);
        dfs(root.right, s, targetSum, map);
        dfs(root.left, s, targetSum, map);
        map.merge(s, -1, Integer::sum);
    }

}
