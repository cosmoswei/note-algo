package com.wei.leetcode.f1500;

class Solution_1328 {
    public String breakPalindrome(String palindrome) {
        int n = palindrome.length();
        if (n == 1) {
            return "";
        }
        // 把第一个不等于 a 的字母改成 a
        // 只需找前一半，如果前一半没有不等于 a 的字母，那么后一半肯定也没有
        char[] s = palindrome.toCharArray();
        for (int i = 0; i < n / 2; i++) {
            if (s[i] != 'a') {
                s[i] = 'a';
                return new String(s);
            }
        }
        // 除了回文中心，全是 a
        s[n - 1] = 'b';  // 最后一个字母改成 b
        return new String(s);
    }
}