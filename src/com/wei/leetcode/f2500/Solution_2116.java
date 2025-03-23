package com.wei.leetcode.f2500;

class Solution_2116 {

    public static void main(String[] args) {
        Solution_2116 solution = new Solution_2116();
        int[] nums = new int[]{7, 1, 5, 3, 6, 4};
        int res = solution.maxProfit(nums);
        System.out.println("res = " + res);
    }

    public int maxProfit(int[] prices) {
        int res = 0;
        int minPrice = prices[0];
        for (int price : prices) {
            res = Math.max(res, price - minPrice);
            minPrice = Math.min(minPrice, price);
        }
        return res;
    }

}