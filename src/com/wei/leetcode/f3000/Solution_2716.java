package com.wei.leetcode.f3000;


public class Solution_2716 {

    public static void main(String[] args) {
        Solution_2716 solution = new Solution_2716();
        long i = solution.minimizedStringLength("param");
        System.out.println("i = " + i);
    }

    public int minimizedStringLength(String s) {
        return (int) s.chars().distinct().count();
    }
}


