package com.wei.leetcode.f500;

class Solution_343 {

    public static void main(String[] args) {
        Solution_343 solution = new Solution_343();
        System.out.println("solution.integerBreak() = " + solution.integerBreak(3433));
    }

    public int integerBreak(int n) {
        if (n <= 3) {
            return (n - 1);
        }
        int a = n / 3;
        int b = n % 3;
        if (b == 1) {
            return (int) (Math.pow(3, a - 1) * 2 * 2);
        }
        if (b == 2) {
            return (int) (Math.pow(3, a) * 2);
        }
        return (int) Math.pow(3, a);
    }
}