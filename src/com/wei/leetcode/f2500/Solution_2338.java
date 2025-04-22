package com.wei.leetcode.f2500;

import java.util.ArrayList;
import java.util.List;

class Solution_2338 {


    public static void main(String[] args) {
        Solution_2338 solution = new Solution_2338();
        int res = solution.idealArrays(2, 5);
        System.out.println("res = " + res);
    }

    private static final int MOD = 1_000_000_007;
    private static final int MAX_N = 10000;
    private static final int MAX_E = 13;
    private static final List<Integer>[] EXP = new ArrayList[MAX_N + 1];
    private static final int[][] C = new int[MAX_N + MAX_E][MAX_E + 1];
    private static boolean done = false;

    private void init() {
        if (done) {
            return;
        }
        done = true;
        for (int i = 1; i < EXP.length; i++) {
            EXP[i] = new ArrayList<>();
            int t = i;
            for (int j = 2; j * j <= t; j++) {
                int e = 0;
                for (; t % j == 0; t /= j) {
                    e++;
                }
                if (e > 0) {
                    EXP[i].add(e);
                }
            }
            if (t > 1) {
                EXP[i].add(1);
            }

        }
        for (int i = 0; i < MAX_N + MAX_E; i++) {
            C[i][0] = 1;
            for (int j = 1; j <= Math.min(i, MAX_E); j++) {
                C[i][j] = (C[i - 1][j] + C[i - 1][j - 1]) % MOD;
            }
        }
    }

    public int idealArrays(int n, int maxValue) {
        init();
        long res = 0;
        for (int i = 1; i <= maxValue; i++) {
            long mul = 1;
            for (Integer e : EXP[i]) {
                mul = mul * C[n + e - 1][e] % MOD;
            }
            res += mul;
        }
        return (int) (res % MOD);
    }
}