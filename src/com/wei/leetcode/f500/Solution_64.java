package com.wei.leetcode.f500;

import java.util.Arrays;

public class Solution_64 {

    public static void main(String[] args) {
        Solution_64 solution = new Solution_64();
        int[][] grid = new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        System.out.println(solution.minPathSum(grid));
    }

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] memo = new int[m][n];
        memo[0][0] = grid[0][0];
        for (int i = 1; i < m; i++) {
            memo[i][0] = grid[i][0] + memo[i - 1][0];
        }
        for (int i = 1; i < n; i++) {
            memo[0][i] = grid[0][i] + memo[0][i - 1];
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                memo[i][j] = grid[i][j] + Math.min(memo[i - 1][j], memo[i][j - 1]);
            }
        }
        return memo[m - 1][n - 1];
    }
}
