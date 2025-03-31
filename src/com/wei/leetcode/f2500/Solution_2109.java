package com.wei.leetcode.f2500;

class Solution_2109 {


    public static void main(String[] args) {
        Solution_2109 solution = new Solution_2109();
        String res = solution.addSpaces("LeetcodeHelpsMeLearn", new int[]{8, 13, 15});
        System.out.println("res = " + res);
    }

    public String addSpaces(String s, int[] spaces) {
        StringBuilder stringBuilder = new StringBuilder(s.length() + spaces.length);
        int j = 0;

        for (int i = 0; i < s.length(); i++) {
            if (j < spaces.length && spaces[j] == i) {
                stringBuilder.append(' ');
                j++;
            }
            stringBuilder.append(s.charAt(i));
        }
        return stringBuilder.toString();

    }
}