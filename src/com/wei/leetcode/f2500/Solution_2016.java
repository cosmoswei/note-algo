package com.wei.leetcode.f2500;

class Solution_2016 {

    public static void main(String[] args) {
        int[] nums = {2, 1, 3, 0};
        int res = new Solution_2016().maximumDifference(nums);
        System.out.println("res = "
                + res);
    }

    public int maximumDifference(int[] nums) {
        int ans = 0;
        int preMin = Integer.MAX_VALUE;
        for (int x : nums) {
            ans = Math.max(ans, x - preMin); // 把 x 当作 nums[j]
            preMin = Math.min(preMin, x);    // 把 x 当作 nums[i]
        }
        return ans > 0 ? ans : -1;
    }
}

