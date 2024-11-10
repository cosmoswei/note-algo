package com.wei.leetcode.f1000;

class Solution_540 {
    public int singleNonDuplicate(int[] nums) {
        int left = -1;
        int right = nums.length / 2;
        while (left + 1 < right) {
            int mid = (left + right) >>> 1;
            if (nums[mid * 2] != nums[mid * 2 + 1]) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return nums[right * 2];
    }
}
