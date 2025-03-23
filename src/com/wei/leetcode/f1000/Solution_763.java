package com.wei.leetcode.f1000;

import java.util.ArrayList;
import java.util.List;

public class Solution_763 {

    public static void main(String[] args) {
        Solution_763 solution = new Solution_763();
        Object res = solution.partitionLabels("ababcbacadefegdehijhklij");
        System.out.println("res = " + res);
    }

    public List<Integer> partitionLabels(String s) {
        char[] charArray = s.toCharArray();
        int n = charArray.length;
        int[] last = new int[26];
        for (int i = 0; i < n; i++) {
            last[charArray[i] - 'a'] = i;
        }
        List<Integer> res = new ArrayList<>();
        int start = 0, end = 0;
        for (int i = 0; i < n; i++) {
            end = Math.max(end, last[charArray[i] - 'a']);
            if (end == i) {
                res.add(end - start + 1);
                start = i + 1;
            }
        }
        return res;
    }

}
