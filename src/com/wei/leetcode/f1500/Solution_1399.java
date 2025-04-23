package com.wei.leetcode.f1500;

class Solution_1399 {

    public static void main(String[] args) {
        Solution_1399 solution = new Solution_1399();
        int res = solution.countLargestGroup(13);
        System.out.println("res = " + res);
    }

    public int countLargestGroup(int n) {
        int res = 0;
        int m = String.valueOf(n).length();
        int[] cnt = new int[m * 9 + 1];
        int maxCnt = 0;
        for (int i = 1; i <= n; i++) {
            int ds = calcDigitSun(i);
            cnt[ds]++;
            if (cnt[ds] > maxCnt) {
                maxCnt = cnt[ds];
                res = 1;
            } else if (cnt[ds] == maxCnt) {
                res++;
            }
        }
        return res;
    }

    private int calcDigitSun(int i) {
        int ds = 0;
        while (i > 0) {
            ds += i % 10;
            i /= 10;
        }
        return ds;
    }
}
