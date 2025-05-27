package com.wei.leetcode.f2500;


public class Solution_2894 {

    public static void main(String[] args) {
        int[] tasks = {3, 2, 1};
        int[] workers = {0, 3, 3};
        Solution_2894 solution = new Solution_2894();
        int i = solution.differenceOfSums(1, 1);
        System.out.println("i = " + i);
    }

    public int differenceOfSums(int n, int m) {
        return n * (n + 1) / 2 - n / m * (n / m + 1) * m;
    }

}
