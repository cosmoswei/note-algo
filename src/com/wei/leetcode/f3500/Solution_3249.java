package com.wei.leetcode.f3500;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution_3249 {
    public int countGoodNodes(int[][] edges) {
        int n = edges.length + 1;
        List<Integer>[] g = new ArrayList[n];
        Arrays.setAll(g, i -> new ArrayList<>());
        for (int[] e : edges) {
            int x = e[0];
            int y = e[1];
            g[x].add(y);
            g[y].add(x);
        }
        dfs(0, -1, g);
        return ans;
    }

    private int ans;

    private int dfs(int x, int fa, List<Integer>[] g) {
        int size = 1;
        int sz0 = 0;
        boolean ok = true;
        for (int y : g[x]) {
            if (y == fa) {
                continue; // 不能递归到父节点
            }
            int sz = dfs(y, x, g);
            if (sz0 == 0) {
                sz0 = sz; // 记录第一个儿子子树的大小
            } else if (sz != sz0) { // 存在大小不一样的儿子子树
                ok = false; // 注意不能 break，其他子树 y 仍然要递归
            }
            size += sz;
        }
        ans += ok ? 1 : 0;
        return size;
    }
}