package com.wei.leetcode.f500;

public class Solution_62 {

    public static void main(String[] args) {
        Solution_62 solution = new Solution_62();
        System.out.println(solution.uniquePaths(34, 37));
    }

    public int uniquePaths(int m, int n) {
        int[][] memo = new int[m][n];
        return dfs(memo, m - 1, n - 1);
    }

    private int dfs(int[][] memo, int m, int n) {
        if (m < 0 || n < 0) {
            return 0;
        }
        if (m == 0 || n == 0) {
            return 1;
        }
        if (memo[m][n] != 0) {
            return memo[m][n];
        }
        return memo[m][n] = dfs(memo, m - 1, n) + dfs(memo, m, n - 1);
    }
}
