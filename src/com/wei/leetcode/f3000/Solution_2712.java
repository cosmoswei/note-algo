package com.wei.leetcode.f3000;


public class Solution_2712 {

    public static void main(String[] args) {
        Solution_2712 solution = new Solution_2712();
        long i = solution.minimumCost("param");
        System.out.println("i = " + i);
    }

    public long minimumCost(String s) {
        char[] charArray = s.toCharArray();
        int n = charArray.length;
        long res = 0;
        for (int i = 1; i < n; i++) {
            if (charArray[i - 1] != charArray[i]) {
                res += Math.min(i, n - i);
            }
        }
        return res;
    }
}


