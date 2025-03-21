package com.wei.leetcode.f3000;

class Solution_2680 {

    public static void main(String[] args) {
        int[] a = new int[]{12, 9};
        Solution_2680 solution = new Solution_2680();
        long l = solution.maximumOr(a, 1);
        System.out.println("l = " + l);
    }

    public long maximumOr(int[] nums, int k) {
        int n = nums.length;
        // suf[i] 表示 nums[i+1] 到 nums[n-1] 的 OR
        int[] suf = new int[n];
        for (int i = n - 2; i >= 0; i--) {
            suf[i] = suf[i + 1] | nums[i + 1];
        }

        long ans = 0;
        // pre 表示 nums[0] 到 nums[i-1] 的 OR
        int pre = 0;
        for (int i = 0; i < n; i++) {
            ans = Math.max(ans, pre | ((long) nums[i] << k) | suf[i]);
            pre |= nums[i];
        }
        return ans;
    }
}

