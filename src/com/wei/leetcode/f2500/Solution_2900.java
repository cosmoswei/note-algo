package com.wei.leetcode.f2500;


import java.util.ArrayList;
import java.util.List;

public class Solution_2900 {

    public static void main(String[] args) {
        String[] tasks = {"3", "2", "1"};
        int[] workers = {0, 3, 3};
        Solution_2900 solution = new Solution_2900();
        List<String> i = solution.getLongestSubsequence(tasks, workers);
        System.out.println("i = " + i);
    }

    public List<String> getLongestSubsequence(String[] words, int[] groups) {
        List<String> res = new ArrayList<>();
        int n = groups.length;
        for (int i = 0; i < n; i++) {
            if (i == n - 1 || groups[i] != groups[i + 1]) {
                res.add(words[i]);
            }
        }
        return res;
    }
}
