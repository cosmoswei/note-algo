package com.wei.leetcode.f3500;

class Solution_3355 {

    public static void main(String[] args) {
        Solution_3355 solution = new Solution_3355();
        int[] nums1 = {3, 0, 1};
        int[][] nums2 = {{3, 0, 1}};
        System.out.println("solution = " + solution.isZeroArray(nums1, nums2));
    }

    public boolean isZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] diff = new int[n + 1];
        for (int[] q : queries) {
            // 区间 [l,r] 中的数都加一
            diff[q[0]]++;
            diff[q[1] + 1]--;
        }

        int sumD = 0;
        for (int i = 0; i < n; i++) {
            sumD += diff[i];
            // 此时 sumD 表示 nums[i] 要减掉多少
            if (nums[i] > sumD) { // nums[i] 无法变成 0
                return false;
            }
        }
        return true;
    }

}