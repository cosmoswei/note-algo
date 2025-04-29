package com.wei.leetcode.f3000;


public class Solution_2962 {

    public static void main(String[] args) {
        Solution_2962 solution = new Solution_2962();
        int[] ints = {5, 5, 5, 5};
        long res = solution.countSubarrays(ints, 2);
        System.out.println("i = " + res);
    }

    public long countSubarrays(int[] nums, int k) {
        long res = 0;
        int mx = 0;

        for (int num : nums) {
            mx = Math.max(num, mx);
        }
        int cntMx = 0, left = 0;
        for (int num : nums) {
            if (mx == num) {
                cntMx++;
            }
            while (cntMx == k) {
                if (nums[left] == mx) {
                    cntMx--;
                }
                left++;
            }
            res += left;
        }
        return res;
    }
}


