package com.wei.leetcode.f500;

import java.util.Arrays;

public class Solution_152 {

    public static void main(String[] args) {
        Solution_152 solution = new Solution_152();
        Object res = solution.maxProduct(new int[]{1, 2, 3, -6, 5, 6, -1, 7});
        System.out.println("res = " + res);
    }

    public int maxProduct(int[] nums) {
        int n = nums.length;
        int[] fMax = new int[n];
        int[] fMin = new int[n];
        fMax[0] = fMin[0] = nums[0];

        for (int i = 1; i < n; i++) {
            int x = nums[i];
            fMax[i] = Math.max(Math.max(fMax[i - 1] * x, fMin[i - 1] * x), x);
            fMin[i] = Math.min(Math.min(fMax[i - 1] * x, fMin[i - 1] * x), x);
        }
        return Arrays.stream(fMax).max().getAsInt();
    }
}
