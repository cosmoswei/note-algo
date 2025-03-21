package com.wei.leetcode.f3000;


import java.util.Arrays;

public class Solution_2643 {

    public static void main(String[] args) {
        Solution_2643 solution = new Solution_2643();
        int[][] grid = {
                {0, 1, 0}, {1, 0, 1}
        };
        int[] ints = solution.rowAndMaximumOnes(grid);
        System.out.println("i = " + Arrays.toString(ints));

    }

    public int[] rowAndMaximumOnes(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] x = new int[m];
        for (int i = 0; i < m; i++) {
            int nums = 0;
            for (int j = 0; j < n; j++) {
                if (mat[i][j] == 1) {
                    nums += 1;
                }
            }
            x[i] = nums;
        }
        int maxIndex = 0;
        int maxNums = 0;
        for (int i = 0; i < x.length; i++) {
            if (x[i] > maxNums) {
                maxIndex = i;
                maxNums = x[i];
            }
        }
        return new int[]{maxIndex, maxNums};
    }
}

