package com.wei.leetcode.f500;

import java.util.Arrays;

public class Solution_279 {

    public static void main(String[] args) {
        Solution_279 solution = new Solution_279();
        Object res = solution.numSquares(14);
        System.out.println("res = " + res);
    }

    public int numSquares(int n) {
        return dfs((int) Math.sqrt(n), n);
    }

    private static int[][] memo = new int[101][10001];

    static {
        for (int[] ints : memo) {
            Arrays.fill(ints, -1);
        }
    }

    public int dfs(int i, int j) {

        if (i <= 0) {
            return j == 0 ? 0 : Integer.MAX_VALUE;
        }
        if (memo[i][j] != -1) {
            return memo[i][j];
        }

        if (j < i * i) {
            return memo[i][j] = dfs(i - 1, j);
        }

        return memo[i][j] = Math.min(dfs(i - 1, j), dfs(i, j - i * i) + 1);
    }
}
