package com.wei.leetcode.f3500;

class Solution_3442 {

    public static void main(String[] args) {
        Solution_3442 solution = new Solution_3442();
        int res = solution.maxDifference("new int[]{1, 2, 3, 4, 56, 7, 7, 8})"
        );
        System.out.println("solution = " + res);
    }

    public int maxDifference(String s) {
        int[] cnt = new int[26];
        for (char b : s.toCharArray()) {
            cnt[b - 'a']++;
        }

        int max1 = 0;
        int min0 = Integer.MAX_VALUE;
        for (int c : cnt) {
            if (c % 2 > 0) {
                max1 = Math.max(max1, c);
            } else if (c > 0) {
                min0 = Math.min(min0, c);
            }
        }
        return max1 - min0;
    }
}
