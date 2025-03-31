package com.wei.leetcode.f2500;


public class Solution_22778 {

    public static void main(String[] args) {
        Solution_22778 solution2085 = new Solution_22778();
        int i = solution2085.percentageLetter("strings1", 's');
        System.out.println("i = " + i);
    }

    public int percentageLetter(String s, char letter) {
        int cnt = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == letter) {
                cnt++;
            }
        }
        return cnt * 100 / s.length();
    }
}
