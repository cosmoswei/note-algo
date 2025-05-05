package com.wei.leetcode.f1000;

public class Solution_790 {

    public static void main(String[] args) {
        Solution_790 solution = new Solution_790();
        System.out.println("solution = " + solution.numTilings(3));
    }

    public static final int MOD = 1_000_000_007;

    public int numTilings(int n) {
        if (n == 1) {
            return 1;
        }
        long[] f = new long[n + 1];
        f[0] = f[1] = 1;
        f[2] = 2;
        for (int i = 3; i <= n; i++) {
            f[i] = (f[i - 1] * 2 + f[i - 3]) % MOD;
        }
        return (int) f[n];
    }
}
