package com.wei.leetcode.f3500;

class Solution_3259 {
    public long maxEnergyBoost(int[] a, int[] b) {
        int n = a.length;
        int[][] c = {a, b};
        long[][] memo = new long[n][2];
        return Math.max(dfs(n - 1, 0, c, memo), dfs(n - 1, 1, c, memo));
    }

    private long dfs(int i, int j, int[][] c, long[][] memo) {
        if (i < 0) {
            return 0;
        }
        if (memo[i][j] > 0) { // 之前计算过
            return memo[i][j];
        }
        return memo[i][j] = Math.max(dfs(i - 1, j, c, memo), dfs(i - 2, j ^ 1, c, memo)) + c[j][i];
    }
}