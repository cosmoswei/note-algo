
package com.wei.leetcode.f500;

public class Solution_45 {

    public static void main(String[] args) {
        Solution_45 solution = new Solution_45();
        int[] nums = new int[]{2,3,1,1,4};
        Object res = solution.jump(nums);
        System.out.println("res = " + res);
    }

    public int jump(int[] nums) {
        int res = 0;
        int curRight = 0;
        int nextRight = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            nextRight = Math.max(nextRight, i + nums[i]);
            if (i == curRight) {
                curRight = nextRight;
                res++;
            }
        }

        return res;
    }
}
