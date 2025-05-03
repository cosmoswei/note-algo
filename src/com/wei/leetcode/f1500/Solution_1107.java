package com.wei.leetcode.f1500;

public class Solution_1107 {

    public static void main(String[] args) {
        int[][] nums = {{1, 2, 10}, {2, 3, 20}, {2, 5, 25}};
        Solution_1107 solution370 = new Solution_1107();
        System.out.println("Solution_1109.corpFlightBookings(nums,5 ) = "
                + solution370.minDominoRotations(nums[0], nums[1]));
    }

    public int minDominoRotations(int[] tops, int[] bottoms) {
        int res = Math.min(minRot(tops, bottoms, tops[0]), minRot(tops, bottoms, bottoms[0]));
        return res == Integer.MAX_VALUE ? -1 : res;
    }

    private int minRot(int[] tops, int[] bottoms, int target) {
        int toTop = 0;
        int toBottom = 0;
        for (int i = 0; i < tops.length; i++) {
            int x = tops[i];
            int y = bottoms[i];
            if (x != target && y != target) {
                return Integer.MAX_VALUE;
            }
            if (x != target) {
                toTop++;
            } else if (y != target) {
                toBottom++;
            }
        }
        return Math.min(toBottom, toTop);
    }

}
