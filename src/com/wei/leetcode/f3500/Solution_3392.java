package com.wei.leetcode.f3500;

class Solution_3392 {

    public static void main(String[] args) {
        Solution_3392 solution = new Solution_3392();
        System.out.println("solution = " + solution.countSubarrays(new int[]{1, 2, 1, 4, 1}));
    }

    public int countSubarrays(int[] nums) {
        int res = 0;
        for (int i = 2; i < nums.length; i++) {
            if ((nums[i - 2] + nums[i]) * 2 == nums[i - 1]) {
                res++;
            }
        }
        return res;
    }
}