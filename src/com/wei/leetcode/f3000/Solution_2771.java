package com.wei.leetcode.f3000;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution_2771 {

    public static void main(String[] args) {
        Solution_2771 solution = new Solution_2771();
        int[][] grid = new int[][]{{1, 2, 3}, {3, 1, 5}, {3, 2, 1}};
        int[][] ints = solution.differenceOfDistinctValues(grid);
        System.out.println("ints = " + Arrays.deepToString(ints));
    }

    public int[][] differenceOfDistinctValues(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] ans = new int[m][n];
        Set<Integer> st = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // 计算 topLeft[i][j]
                st.clear();
                for (int x = i - 1, y = j - 1; x >= 0 && y >= 0; x--, y--) {
                    st.add(grid[x][y]);
                }
                int topLeft = st.size();

                // 计算 bottomRight[i][j]
                st.clear();
                for (int x = i + 1, y = j + 1; x < m && y < n; x++, y++) {
                    st.add(grid[x][y]);
                }
                int bottomRight = st.size();

                ans[i][j] = Math.abs(topLeft - bottomRight);
            }
        }
        return ans;
    }

}