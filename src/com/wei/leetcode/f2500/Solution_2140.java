package com.wei.leetcode.f2500;


public class Solution_2140 {

    public static void main(String[] args) {
        int[][] strings1 = {{2, 3}, {2, 3}, {2, 3}, {2, 3}, {2, 3}};
        Solution_2140 solution = new Solution_2140();
        long i = solution.mostPoints(strings1);
        System.out.println("i = " + i);
    }

    public long mostPoints(int[][] questions) {
        long[] memo = new long[questions.length];
        return dfs(0, questions, memo);
    }

    private long dfs(int i, int[][] ques, long[] memo) {

        if (i >= memo.length) {
            return 0;
        }

        if (memo[i] > 0) {
            return memo[i];
        }

        long n = dfs(i + 1, ques, memo);
        long y = dfs(i + ques[i][1] + 1, ques, memo) + ques[i][0];
        return memo[i] = Math.max(n, y);
    }
}
