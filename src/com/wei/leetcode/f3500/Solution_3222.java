package com.wei.leetcode.f3500;

class Solution_3222 {
    public String losingPlayer(int x, int y) {
        return Math.min(x, y / 4) % 2 != 0 ? "Alice" : "Bob";
    }
}