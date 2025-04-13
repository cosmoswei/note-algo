package com.wei.leetcode.f2000;

class Solution_1922 {

    public static void main(String[] args) {
        Solution_1922 solution = new Solution_1922();
        int i = solution.countGoodNumbers(50);
        System.out.println("i = " + i);
    }

    private static int MOD = 1_000_000_007;

    public int countGoodNumbers(long n) {
        return (int) (pow(5, (n + 1) / 2) * pow(4, n / 2) % MOD);
    }

    private long pow(long x, long n) {
        long res = 1;
        while (n > 0) {
            if ((n & 1) > 0) {
                res = res * x % MOD;
            }
            x = x * x % MOD;
            n >>= 1;
        }
        return res;
    }
}

