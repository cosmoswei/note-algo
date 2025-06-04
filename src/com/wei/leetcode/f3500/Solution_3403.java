package com.wei.leetcode.f3500;

class Solution_3403 {

    public static void main(String[] args) {
        Solution_3403 solution = new Solution_3403();
        String res = solution.answerString("", 2);
        System.out.println("res = " + res);
    }

    public String answerString(String s, int k) {
        if (k == 1) {
            return s;
        }
        int n = s.length();
        String ans = "";
        for (int i = 0; i < n; i++) {
            String sub = s.substring(i, Math.min(i + n - k + 1, n));
            if (sub.compareTo(ans) > 0) {
                ans = sub;
            }
        }
        return ans;
    }
}
