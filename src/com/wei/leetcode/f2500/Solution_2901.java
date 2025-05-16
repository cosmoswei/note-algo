package com.wei.leetcode.f2500;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Solution_2901 {

    public static void main(String[] args) {
        String[] tasks = {"3", "2", "1"};
        int[] workers = {0, 3, 3};
        Solution_2901 solution = new Solution_2901();
        List<String> i = solution.getWordsInLongestSubsequence(tasks, workers);
        System.out.println("i = " + i);
    }


    private static class Info {
        int maxF;
        int j;
        int maxF2;
        int j2;

        public Info(int maxF, int j, int maxF2, int j2) {
            this.maxF = maxF;
            this.j = j;
            this.maxF2 = maxF2;
            this.j2 = j2;
        }
    }

    public List<String> getWordsInLongestSubsequence(String[] words, int[] groups) {
        int n = words.length;
        Map<Long, Info> fMap = new HashMap<>();
        int[] from = new int[n];
        int globalMaxF = 0;
        int maxI = 0;

        for (int i = n - 1; i >= 0; i--) {
            char[] w = words[i].toCharArray();
            int g = groups[i];

            // 计算 w 的哈希值
            long hash = 0;
            for (char c : w) {
                hash = (hash << 5) | (c & 31);
            }

            int f = 0; // 方法一中的 f[i]
            for (int k = 0; k < w.length; k++) {
                long h = hash | (31L << (k * 5)); // 用记号笔把 w[k] 涂黑（置为 11111）
                Info t = fMap.get(h);
                if (t == null) {
                    continue;
                }
                if (g != groups[t.j]) { // 可以从最大值转移过来
                    if (t.maxF > f) {
                        f = t.maxF;
                        from[i] = t.j;
                    }
                } else { // 只能从次大值转移过来
                    if (t.maxF2 > f) {
                        f = t.maxF2;
                        from[i] = t.j2;
                    }
                }
            }

            f++;
            if (f > globalMaxF) {
                globalMaxF = f;
                maxI = i;
            }

            // 用 f 更新 fMap[h] 的最大次大
            // 注意要保证最大次大的 group 值不同
            for (int k = 0; k < w.length; k++) {
                long h = hash | (31L << (k * 5));
                Info t = fMap.getOrDefault(h, new Info(0, 0, 0, 0));
                int maxF = t.maxF, j = t.j, maxF2 = t.maxF2, j2 = t.j2;
                if (f > maxF) { // 最大值需要更新
                    if (g != groups[j]) {
                        maxF2 = maxF; // 旧最大值变成次大值
                        j2 = j;
                    }
                    maxF = f;
                    j = i;
                } else if (f > maxF2 && g != groups[j]) { // 次大值需要更新
                    maxF2 = f;
                    j2 = i;
                }
                fMap.put(h, new Info(maxF, j, maxF2, j2));
            }
        }

        List<String> ans = new ArrayList<>(globalMaxF); // 预分配空间
        int i = maxI;
        for (int k = 0; k < globalMaxF; k++) {
            ans.add(words[i]);
            i = from[i];
        }
        return ans;
    }
}

