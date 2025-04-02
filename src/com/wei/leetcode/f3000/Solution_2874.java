package com.wei.leetcode.f3000;

class Solution_2874 {

    public static void main(String[] args) {
        Solution_2874 solution = new Solution_2874();
        long l = solution.maximumTripletValue(new int[]{12, 6, 1, 2, 7});
        System.out.println("l = " + l);
    }

    public long maximumTripletValue(int[] nums) {
        int n = nums.length;
        int[] subMax = new int[n + 1];
        for (int i = n - 1; i > 1; i--) {
            subMax[i] = Math.max(subMax[i + 1], nums[i]);
        }

        long res = 0;
        int preMax = nums[0];
        for (int i = 0; i < n - 1; i++) {

            res = Math.max(res, (long) (preMax - nums[i]) * subMax[i + 1]);
            preMax = Math.max(preMax, nums[i]);
        }
        return res;
    }

}