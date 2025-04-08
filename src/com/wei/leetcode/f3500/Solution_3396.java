package com.wei.leetcode.f3500;

import java.util.HashSet;
import java.util.Set;

class Solution_3396 {

    public static void main(String[] args) {
        Solution_3396 solution = new Solution_3396();
        System.out.println("solution = " + solution.minimumOperations(new int[]{1, 2, 3, 4, 56, 7, 7, 8}));
    }

    public int minimumOperations(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            if (!set.add(nums[i])) {
                return i / 3 + 1;
            }
        }
        return 0;
    }
}