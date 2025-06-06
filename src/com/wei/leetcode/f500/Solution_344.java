package com.wei.leetcode.f500;

class Solution_344 {

    public static void main(String[] args) {
        Solution_344 solution = new Solution_344();
        char[] nums = {'1', '2', '3', '4', '5', '6', '7'};
        solution.reverseString(nums);
        for (int j = 0; j < nums.length; j++) {
            System.out.println("i = " + nums[j]);
        }
    }

    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while (left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }
}