package com.wei.leetcode.f500;

public class Solution_55 {

    public static void main(String[] args) {
        Solution_55 solution = new Solution_55();
        int[] nums = new int[]{7, 1, 5, 3, 6, 4};
        Object res = solution.canJump(nums);
        System.out.println("res = " + res);
    }


    public boolean canJump(int[] nums) {
        int mx = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > mx) {
                return false;
            }

            mx = Math.max(mx, nums[i] + i);
        }
        return true;
    }
}
