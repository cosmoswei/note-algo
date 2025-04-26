package com.wei.leetcode.f2500;

class Solution_2444 {


    public static void main(String[] args) {
        Solution_2444 solution = new Solution_2444();
        long res = solution.countSubarrays(new int[]{8, 13, 15}, 1, 3);
        System.out.println("res = " + res);
    }

    public long countSubarrays(int[] nums, int minK, int maxK) {
        long res = 0;
        long minI = -1, maxI = -1, i0 = -1;
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            if (x == minK) {
                minI = i;
            }
            if (x == maxK) {
                maxI = i;
            }
            if (x < minK || x > maxK) {
                i0 = i;
            }
            res += Math.max(Math.min(maxI, minI) - i0, 0);
        }
        return res;
    }
}