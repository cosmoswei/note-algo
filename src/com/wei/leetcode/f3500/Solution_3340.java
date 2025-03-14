package com.wei.leetcode.f3500;

class Solution_3340 {

    public static void main(String[] args) {
        Solution_3340 solution = new Solution_3340();
        System.out.println("solution = " + solution.isBalanced("24123"));
    }

    public boolean isBalanced(String num) {
        int sum = 0;
        char[] charArray = num.toCharArray();
        for (int i = 0; i < charArray.length; i++) {
            int c = charArray[i] - '0';
            sum += i % 2 > 0 ? c : -c;
        }
        return sum == 0;
    }
}