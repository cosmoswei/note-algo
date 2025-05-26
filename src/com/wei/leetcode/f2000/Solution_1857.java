package com.wei.leetcode.f2000;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution_1857 {

    public static void main(String[] args) {
        Solution_1857 solution = new Solution_1857();
        int[][] edges = {};
        int i = solution.largestPathValue("", edges);
        System.out.println("i = " + i);
    }

    public int largestPathValue(String colors, int[][] edges) {
        int n = colors.length();
        List<Integer>[] g = new ArrayList[n];
        Arrays.setAll(g, i -> new ArrayList<>());
        for (int[] e : edges) {
            int x = e[0];
            int y = e[1];
            if (x == y) { // 自环
                return -1;
            }
            g[x].add(y);
        }

        int ans = 0;
        char[] cs = colors.toCharArray();
        int[][] memo = new int[n][];
        for (int x = 0; x < n; x++) {
            int[] res = dfs(x, g, cs, memo);
            if (res.length == 0) { // 有环
                return -1;
            }
            ans = Math.max(ans, res[cs[x] - 'a']);
        }
        return ans;
    }

    private int[] dfs(int x, List<Integer>[] g, char[] colors, int[][] memo) {
        if (memo[x] != null) { // x 计算中或者计算过
            return memo[x]; // 如果是空数组，表示有环
        }
        memo[x] = new int[]{}; // 表示计算中
        int[] res = new int[26];
        for (int y : g[x]) {
            int[] cy = dfs(y, g, colors, memo);
            if (cy.length == 0) { // 有环
                return cy;
            }
            for (int i = 0; i < 26; i++) {
                res[i] = Math.max(res[i], cy[i]);
            }
        }
        res[colors[x] - 'a']++;
        return memo[x] = res; // 记忆化，同时也表示 x 计算完毕
    }

}

