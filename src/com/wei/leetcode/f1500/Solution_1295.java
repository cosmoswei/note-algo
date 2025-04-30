package com.wei.leetcode.f1500;

class Solution_1295 {

    public static void main(String[] args) {
        Solution_1295 solution = new Solution_1295();
        int[] ints = {5, 5, 5, 5};
        int res = solution.findNumbers(ints);
        System.out.println("i = " + res);
    }

    public int findNumbers(int[] nums) {
        int res = 0;
        for (int num : nums) {
            int len = numLne(num);
            if (len % 2 == 0) {
                res++;
            }
        }
        return res;
    }


    private int numLne(int n) {
        return String.valueOf(n).length();
    }

}
