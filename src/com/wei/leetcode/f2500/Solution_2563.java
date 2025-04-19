package com.wei.leetcode.f2500;


import java.util.Arrays;

public class Solution_2563 {

    public static void main(String[] args) {
        Solution_2563 solution = new Solution_2563();
        int[] param = {0, 1, 7, 4, 4, 5};
        long i = solution.countFairPairs(param, 3, 6);
        System.out.println("i = " + i);
    }

    public long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        long res = 0;
        for (int i = 0; i < nums.length; i++) {
            int r = lowerBound(nums, i, upper - nums[i] + 1);
            int l = lowerBound(nums, i, lower - nums[i]);
            res += r - l;
        }
        return res;
    }

    private int lowerBound(int[] nums, int right, int t) {
        int left = -1;
        while (left + 1 < right) {
            int mid = (left + right) >>> 1;
            if (nums[mid] >= t) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return right;
    }
}


