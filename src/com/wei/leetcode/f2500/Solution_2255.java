package com.wei.leetcode.f2500;


import java.util.ArrayList;
import java.util.List;

public class Solution_2255 {

    public static void main(String[] args) {
        Solution_2255 solution = new Solution_2255();
        String[] strings = new String[]{"a", "b", "c", "ab", "bc", "abc"};
        Object res = solution.countPrefixes(strings, "abc");
        System.out.println("res = " + res);
    }

    int countPrefixes(String[] words, String s) {
        int ans = 0;
        for (String word : words) {
            if (s.startsWith(word)) {
                ans++;
            }
        }
        return ans;
    }

    public int countPrefixes0(String[] words, String s) {
        int res = 0;
        char[] charArray = s.toCharArray();
        List<String> prefixStrList = new ArrayList<>();
        String prefixStr = "";
        for (int i = 0; i < charArray.length; i++) {
            prefixStr += charArray[i];
            prefixStrList.add(prefixStr);
        }
        for (int i = 0; i < words.length; i++) {
            if (prefixStrList.contains(words[i])) {
                res++;
            }
        }
        return res;
    }
}
