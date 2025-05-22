package com.wei.leetcode.f3500;

class Solution_3356 {

    public static void main(String[] args) {
        Solution_3356 solution = new Solution_3356();
        int[] nums1 = {3, 0, 1};
        int[][] nums2 = {{3, 0, 1}};
        System.out.println("solution = " + solution.minZeroArray(nums1, nums2));
    }

    public int minZeroArray(int[] nums, int[][] queries) {
        int n = nums.length;
        int[] diff = new int[n + 1];
        int sumD = 0;
        int k = 0;
        for (int i = 0; i < n; i++) {
            int x = nums[i];
            sumD += diff[i];
            while (k < queries.length && sumD < x) { // 需要添加询问，把 x 减小
                int[] q = queries[k];
                int l = q[0], r = q[1], val = q[2];
                diff[l] += val;
                diff[r + 1] -= val;
                if (l <= i && i <= r) { // x 在更新范围中
                    sumD += val;
                }
                k++;
            }
            if (sumD < x) { // 无法更新
                return -1;
            }
        }
        return k;
    }
}