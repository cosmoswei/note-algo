package com.wei.leetcode.f500;

public class Solution_70 {

    public static void main(String[] args) {
        Solution_70 solution = new Solution_70();
        System.out.println(solution.climbStairs(37));
    }

    int[] mem;

    public int climbStairs(int n) {
        mem = new int[n + 1];
        return dfs(n);
    }

    private int dfs(int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        if (n == 2) {
            return 2;
        }
        if (mem[n] != 0) {
            return mem[n];
        }
        int step1 = dfs(n - 1);
        int step2 = dfs(n - 2);
        mem[n] = step1 + step2;
        return mem[n];
    }
}
