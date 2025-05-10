package com.wei.leetcode.f3000;


public class Solution_2918 {

    public static void main(String[] args) {
        Solution_2918 solution = new Solution_2918();
        int[] grid = {1, 1, 1, 1, 1};
        int[] grid2 = {1, 1, 1, 1, 1};
        long res = solution.minSum(grid, grid2);
        System.out.println("i = " + res);

    }

    public long minSum(int[] nums1, int[] nums2) {
        Pair p1 = calc(nums1);
        Pair p2 = calc(nums2);
        if (!p1.zero && p1.sum < p2.sum || !p2.zero && p2.sum < p1.sum) {
            return -1;
        }
        return Math.max(p1.sum, p2.sum);
    }

    class Pair {
        long sum;
        boolean zero;

        public Pair(long sum, boolean zero) {
            this.sum = sum;
            this.zero = zero;
        }
    }

    public Pair calc(int[] nums) {
        long sum = 0;
        boolean zero = false;
        for (int num : nums) {
            if (num == 0) {
                zero = true;
                sum++;
            } else {
                sum += num;
            }
        }
        return new Pair(sum, zero);
    }

}

