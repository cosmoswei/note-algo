package com.wei.leetcode.f3500;

class Solution_3226 {
    public int minChanges(int n, int k) {
        return (n & k) != k ? -1 : Integer.bitCount(n ^ k);
    }
}