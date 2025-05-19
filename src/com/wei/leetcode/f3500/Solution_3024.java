package com.wei.leetcode.f3500;

import java.util.Arrays;

class Solution_3024 {
    public static void main(String[] args) {
        Solution_3024 solution = new Solution_3024();
        int[] nums1 = {3, 0, 1};
        String i = solution.triangleType(nums1);
        System.out.println("i = " + i);
    }

    public String triangleType(int[] nums) {
        Arrays.sort(nums);
        int a = nums[0];
        int b = nums[1];
        int c = nums[2];
        if (a + b <= c) {
            return "none";
        }
        if (a == c) {
            return "equilateral";
        }
        if (a == b || b == c) {
            return "isosceles";
        }
        return "scalene";
    }

}
