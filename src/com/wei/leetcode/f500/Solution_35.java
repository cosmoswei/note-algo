package com.wei.leetcode.f500;

class Solution_35 {

    public static void main(String[] args) {
        Solution_35 solution = new Solution_35();
        int[] nums = new int[]{1, 3, 5, 6};
        System.out.println("solution = " + solution.searchInsert(nums, 2));
    }

    public int searchInsert(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

}


