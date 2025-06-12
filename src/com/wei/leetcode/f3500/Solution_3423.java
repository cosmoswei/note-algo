package com.wei.leetcode.f3500;

class Solution_3423 {

    public static void main(String[] args) {
        Solution_3423 solution = new Solution_3423();
        System.out.println("solution = " + solution.maxAdjacentDistance(new int[]{1, 2, 4}));
    }

    public int maxAdjacentDistance(int[] nums) {
        int len = nums.length;
        int res = Math.abs(nums[0] - nums[len - 1]);
        for (int i = 0; i < nums.length - 1; i++) {
            int abs = Math.abs(nums[i] - nums[i + 1]);
            if (abs > res) {
                res = abs;
            }
        }
        return res;
    }
}