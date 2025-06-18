package com.wei.leetcode.f3000;

import java.util.Arrays;

class Solution_2966 {

    public static void main(String[] args) {
        Solution_2966 solution = new Solution_2966();
        int[][] ints = solution.divideArray(new int[]{1, 23, 4, 5}, 3);
        System.out.println("ints = " + Arrays.deepToString(ints));
    }

    public int[][] divideArray(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int[][] ans = new int[n / 3][];
        for (int i = 2; i < n; i += 3) {
            if (nums[i] - nums[i - 2] > k) {
                return new int[][]{};
            }
            ans[i / 3] = new int[]{nums[i - 2], nums[i - 1], nums[i]};
        }
        return ans;
    }
}
