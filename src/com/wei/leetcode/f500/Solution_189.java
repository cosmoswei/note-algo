package com.wei.leetcode.f500;

import java.util.Arrays;

public class Solution_189 {

    public static void main(String[] args) {
        Solution_189 solution = new Solution_189();
        int[] ints = {1, 2, 3, 4, 5, 6, 7}; // 5,6,7,1,2,3,4
        solution.rotate(ints, 3);
        System.out.println("ints = " + Arrays.toString(ints));
    }

    public void rotate(int[] nums, int k) {
        int len = nums.length;
        k %= len;
        reverse(nums, 0, len - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, len - 1);
    }

    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            int temp = nums[i];
            nums[i++] = nums[j];
            nums[j--] = temp;
        }
    }
}
