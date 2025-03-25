package com.wei.leetcode.f1500;

import java.util.Arrays;

public class Solution_1143 {

    public static void main(String[] args) {
        int[][] nums = {{2, 1, 5}, {3, 3, 7}};
        Solution_1143 solution370 = new Solution_1143();
        System.out.println("Solution = "
                + solution370.longestCommonSubsequence("abcde", "ace"));
        System.out.println("nums = " + Arrays.deepToString(solution370.memo));
    }

    private char[] s, t;
    private int[][] memo;

    public int longestCommonSubsequence(String text1, String text2) {
        s = text1.toCharArray();
        t = text2.toCharArray();
        int m = s.length;
        int n = t.length;
        memo = new int[m][n];
        for (int[] ints : memo) {
            Arrays.fill(ints, -1);
        }

        return dfs(m - 1, n - 1);
    }

    private int dfs(int i, int j) {
        if (i < 0 || j < 0) {
            return 0;
        }
        if (memo[i][j] != -1) {
            return memo[i][j];
        }
        if (s[i] == t[j]) {
            return    memo[i][j] = dfs(i - 1, j - 1) + 1;
        }
        return memo[i][j] = Math.max(dfs(i - 1, j), dfs(i, j - 1));
    }
}
