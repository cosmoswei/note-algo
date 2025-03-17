package com.wei.leetcode.f500;

public class Solution_41 {

    public static void main(String[] args) {
        System.out.println("Solution = "
                + (new Solution_41().firstMissingPositive(new int[]{1, 2, 3, 4, 5, 6, 7})));

    }

    public int firstMissingPositive(int[] nums) {
        int res = 0;
        int len = nums.length;
        for (int i = 0; i < len; i++) {
            if (nums[i] <= 0) {
                nums[i] = len + 1;
            }
        }

        for (int i = 0; i < len; i++) {
            int abs = Math.abs(nums[i]);
            if (abs <= len) {
                nums[abs - 1] = -Math.abs(nums[abs - 1]);
            }
        }

        for (int i = 0; i < len; i++) {
            int num = nums[i];
            if (num >= 0) {
                return i + 1;
            }
        }
        return len + 1;
    }
}
