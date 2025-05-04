package com.wei.leetcode.f1500;

public class Solution_1128 {

    public static void main(String[] args) {
        int[][] nums = {{1, 2, 10}, {2, 3, 20}, {2, 5, 25}};
        Solution_1128 solution370 = new Solution_1128();
        System.out.println("Solution_1109.corpFlightBookings(nums,5 ) = "
                + solution370.numEquivDominoPairs(nums));
    }

    public int numEquivDominoPairs(int[][] dominoes) {
        int res = 0;
        int[] num = new int[100];
        for (int[] dominoe : dominoes) {
            int val = dominoe[0] < dominoe[1] ? dominoe[0] * 10 + dominoe[1] : dominoe[1] * 10 + dominoe[0];
            res += num[val];
            num[val]++;
        }
        return res;
    }

}
