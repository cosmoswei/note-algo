package com.wei.leetcode.f2500;

import java.util.Arrays;

class Solution_2272 {
    public int largestVariance(String s) {
        int ans = 0;
        int[][] f0 = new int[26][26];
        int[][] f1 = new int[26][26];
        for (int[] row : f1) {
            Arrays.fill(row, Integer.MIN_VALUE);
        }

        for (char ch : s.toCharArray()) {
            ch -= 'a';
            // 遍历到 ch 时，只需计算 a=ch 或者 b=ch 的状态，其他状态和 ch 无关，f 值不变
            for (int i = 0; i < 26; i++) {
                if (i == ch) {
                    continue;
                }
                // 假设出现次数最多的字母 a=ch，更新所有 b=i 的状态
                f0[ch][i] = Math.max(f0[ch][i], 0) + 1;
                f1[ch][i]++;
                // 假设出现次数最少的字母 b=ch，更新所有 a=i 的状态
                f1[i][ch] = f0[i][ch] = Math.max(f0[i][ch], 0) - 1;
                ans = Math.max(ans, Math.max(f1[ch][i], f1[i][ch]));
            }
        }
        return ans;
    }
}
