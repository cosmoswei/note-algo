package com.wei.leetcode.f2500;

class Solution_2145 {


    public static void main(String[] args) {
        Solution_2145 solution = new Solution_2145();
        int res = solution.numberOfArrays(new int[]{1, -3, 4}, 1, 6);
        System.out.println("res = " + res);
    }

    public int numberOfArrays(int[] differences, int lower, int upper) {
        long s = 0, minS = 0, maxS = 0;
        for (int difference : differences) {
            s += difference;
            minS = Math.min(minS, s);
            maxS = Math.max(maxS, s);
        }
        return (int) Math.max(upper - lower - maxS + minS + 1, 0);
    }
}