package com.wei.leetcode.f500;

class Solution_84 {

    public static void main(String[] args) {
        Solution_84 solution128 = new Solution_84();
        int[] nums = new int[]{2, 1, 5, 6, 2, 3};
        System.out.println("solution128.maxEnvelopes(nums) = " + solution128.largestRectangleArea(nums));
    }

    public int largestRectangleArea(int[] heights) {
        int res = 0;
        int n = heights.length;

        for (int i = 0; i < n; i++) {
            int left = i;
            int curHigh = heights[i];
            if (i > 0 && heights[i] == heights[i - 1]) {
                continue;
            }
            while (left > 0 && heights[left - 1] >= curHigh) {
                left--;
            }

            int right = i;
            while (right < n - 1 && heights[right + 1] >= curHigh) {
                right++;
            }
            int wide = right - left + 1;
            res = Math.max(wide * curHigh, res);
        }
        return res;
    }
}


