package com.wei.leetcode.f3500;

class Solution_3239 {
    public int minFlips(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int diffRow = 0;
        for (int[] row : grid) {
            for (int j = 0; j < n / 2; j++) {
                if (row[j] != row[n - 1 - j]) {
                    diffRow++;
                }
            }
        }

        int diffCol = 0;
        for (int j = 0; j < n; j++) {
            for (int i = 0; i < m / 2; i++) {
                if (grid[i][j] != grid[m - 1 - i][j]) {
                    diffCol++;
                }
            }
        }

        return Math.min(diffRow, diffCol);
    }
}
