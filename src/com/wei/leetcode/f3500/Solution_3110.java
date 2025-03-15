package com.wei.leetcode.f3500;

class Solution_3110 {

    public static void main(String[] args) {
        Solution_3110 solution = new Solution_3110();
        System.out.println("solution = " + solution.scoreOfString("hello"));
    }
    public int scoreOfString(String s) {
        char[] charArray = s.toCharArray();
        int left = 0, right = 1;
        int sum = 0;
        while (right < charArray.length) {
            char l = charArray[left];
            char r = charArray[right];
            sum += Math.abs(l - r);
            left++;
            right++;
        }
        return sum;
    }
}