package com.wei.leetcode.f3000;


import java.util.HashMap;
import java.util.Map;

public class Solution_2929 {

    public static void main(String[] args) {
        Solution_2929 solution = new Solution_2929();
        int[] grid = {1,1,1,1,1};
        long res = solution.distributeCandies(5, 2);
        System.out.println("i = " + res);

    }

    public long distributeCandies(int n, int limit) {
        return c2(n + 2) - 3 * c2(n - limit + 1) + 3 * c2(n - 2 * limit) - c2(n - 3 * limit - 1);
    }

    private long c2(int n) {
        return n > 1 ? (long) n * (n - 1) / 2 : 0;
    }

}

