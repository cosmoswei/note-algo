package com.wei.leetcode.f2000;

import java.util.Arrays;

class Solution_1920 {

    public static void main(String[] args) {
        Solution_1920 solution = new Solution_1920();
        int[] nums1 = {0, 2, 1, 5, 3, 4};
        int[] res = solution.buildArray(nums1);
        System.out.println("i = " + Arrays.toString(res));
    }

    public int[] buildArray(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int x = nums[i];
            if (x < 0) {
                continue;
            }
            int cur = i;
            while (nums[cur] != i) {
                int nxt = nums[cur];
                nums[cur] = ~nums[nxt];
                cur = nxt;
            }
            nums[cur] = ~x;
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = ~nums[i];
        }
        return nums;
    }
}

