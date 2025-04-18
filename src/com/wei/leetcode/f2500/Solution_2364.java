package com.wei.leetcode.f2500;


import java.util.HashMap;
import java.util.Map;

public class Solution_2364 {

    public static void main(String[] args) {
        Solution_2364 solution = new Solution_2364();
        int[] param = {4, 1, 3, 3};
        long i = solution.countBadPairs(param);
        System.out.println("i = " + i);
    }

    public long countBadPairs(int[] nums) {
        int n = nums.length;
        long res = (long) n * (n - 1) / 2;
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int x = nums[i] - i;
            int c = map.getOrDefault(x, 0);
            res -= c;
            map.put(x, c + 1);
        }
        return res;
    }
}


