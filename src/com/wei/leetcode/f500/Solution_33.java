package com.wei.leetcode.f500;

class Solution_33 {
    public static void main(String[] args) {
        Solution_33 solution = new Solution_33();
        int[] nums = {4, 5, 6, 7, 0, 1, 2};
        System.out.println("solution.search(nums,2) = " + solution.search(nums, 1));
    }

    public int search(int[] nums, int target) {
        int left = -1, right = nums.length - 1;
        while (left + 1 < right) {
            int mid = left + (right - left) / 2;
            if (isBlue(nums, target, mid)) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return nums[right] == target ? right : -1;
    }

    private boolean isBlue(int[] nums, int target, int i) {
        int end = nums[nums.length - 1];
        if (nums[i] > end) {
            return target > end && nums[i] >= target;
        }
        return target > end || nums[i] >= target;
    }
}