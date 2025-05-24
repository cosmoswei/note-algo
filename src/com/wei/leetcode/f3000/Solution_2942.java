package com.wei.leetcode.f3000;


import java.util.ArrayList;
import java.util.List;

public class Solution_2942 {

    public static void main(String[] args) {
        Solution_2942 solution = new Solution_2942();
        String[] words = {"leet", "code"};
        List<Integer> res = solution.findWordsContaining(words, 'e');
        System.out.println("res = " + res);

    }

    public List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            for (char c : words[i].toCharArray()) {
                if (c == x) {
                    res.add(i);
                    break;
                }
            }
        }
        return res;
    }
}

