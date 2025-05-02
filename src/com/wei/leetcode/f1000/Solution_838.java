package com.wei.leetcode.f1000;

import java.util.Arrays;

class Solution_838 {

    public static void main(String[] args) {
        Solution_838 solution = new Solution_838();
        String i = solution.pushDominoes("RR.L");
        System.out.println("i = " + i);
    }

    public String pushDominoes(String dominoes) {
        char[] s = ("L" + dominoes + "R").toCharArray();
        int pre = 0;
        for (int i = 1; i < s.length; i++) {
            if (s[i] == '.') {
                continue;
            }
            if (s[i] == s[pre]) {
                Arrays.fill(s, pre + 1, i, s[i]);
            } else if (s[i] == 'L') {
                Arrays.fill(s, pre + 1, (pre + 1 + i) / 2, 'R');
                Arrays.fill(s, (pre + i) / 2 + 1, i, 'L');
            }
            pre = i;
        }
        return new String(s, 1, s.length - 2);
    }
}