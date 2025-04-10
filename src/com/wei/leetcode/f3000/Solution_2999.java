package com.wei.leetcode.f3000;


import java.util.Arrays;

public class Solution_2999 {

    public static void main(String[] args) {
        Solution_2999 solution = new Solution_2999();
        int start = 1, finish = 6000, limit = 4;
        String s = "124";
        long res = solution.numberOfPowerfulInt(start, finish, limit, s);
        System.out.println("ints = " + res);
    }

    public static String repeat(String original, int count) {
        if (original == null) {
            return null;
        }
        if (count <= 0) {
            return "";
        }
        final StringBuilder builder = new StringBuilder(original.length() * count);
        for (int i = 0; i < count; i++) {
            builder.append(original);
        }
        return builder.toString();

    }

    public long numberOfPowerfulInt(long start, long finish, int limit, String s) {
        String low = Long.toString(start);
        String high = Long.toString(finish);
        int n = high.length();
        low = repeat("0", n - low.length()) + low;
        long[] memo = new long[n];
        Arrays.fill(memo, -1);
        return dfs(0, true, true, low.toCharArray(),
                high.toCharArray(), limit, s.toCharArray(), memo);
    }

    public long dfs(int i, boolean limitLow, boolean limitHigh, char[] low,
                    char[] high, int limit, char[] s, long[] memo) {
        if (i == high.length) {
            return 1;
        }

        if (!limitHigh && !limitLow && memo[i] != -1) {
            return memo[i];
        }

        int lo = limitLow ? low[i] - '0' : 0;
        int hi = limitHigh ? high[i] - '0' : 9;
        long res = 0;
        if (i < high.length - s.length) {
            for (int d = lo; d <= Math.min(hi, limit); d++) {
                res += dfs(i + 1, limitLow && d == lo,
                        limitHigh && d == hi,
                        low, high, limit, s, memo);
            }
        } else {
            int x = s[i - (high.length - s.length)] - '0';
            if (lo <= x && x <= Math.min(hi, limit)) {
                res = dfs(i + 1,
                        limitLow && x == lo,
                        limitHigh && x == hi
                        , low, high, limit, s, memo);
            }
        }

        if (!limitHigh && !limitLow) {
            memo[i] = res;
        }
        return res;
    }
}

