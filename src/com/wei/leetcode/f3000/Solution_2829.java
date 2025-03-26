package com.wei.leetcode.f3000;

class Solution_2829 {
    public int minimumSum(int n, int k) {
        int m = Math.min(n, k / 2);
        return (m * (m + 1) + (k * 2 + n - m + -1) * (n - m)) / 2;
    }

}
