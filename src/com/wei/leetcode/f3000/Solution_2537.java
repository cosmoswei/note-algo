package com.wei.leetcode.f3000;


import java.util.HashMap;
import java.util.Map;

public class Solution_2537 {

    public static void main(String[] args) {
        Solution_2537 solution = new Solution_2537();
        int[] grid = {1,1,1,1,1};
        long res = solution.countGood(grid, 10);
        System.out.println("i = " + res);

    }

    public long countGood(int[] nums, int k) {
        long res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        int pairs = 0;
        int left = 0;
        for (int x : nums) {
            int c = map.getOrDefault(x, 0);
            pairs += c;
            map.put(x, c + 1);
            while (pairs >= k) {
                x = nums[left];
                c = map.get(x);
                pairs -= c - 1;
                map.put(x, c - 1);
                left++;
            }
            res += left;
        }
        return res;
    }
}

