package com.wei.leetcode.f2500;

class Solution_2131 {

    public static void main(String[] args) {
        Solution_2131 solution = new Solution_2131();
        String[] words = {"lc", "cl", "gg"};
        int res = solution.longestPalindrome(words);
        System.out.println("res = " + res);
    }

    public int longestPalindrome(String[] words) {

        int[][] cnt = new int[26][26];
        for (String word : words) {
            cnt[word.charAt(0) - 'a'][word.charAt(1) - 'a']++;
        }

        int res = 0;
        int odd = 0;
        for (int i = 0; i < 26; i++) {
            int c = cnt[i][i];
            res += c - c % 2;
            odd |= c % 2;
            for (int j = i + 1; j < 26; j++) {
                res += Math.min(cnt[i][j], cnt[j][i]) * 2;
            }
        }
        return (res + odd) * 2;
    }
}