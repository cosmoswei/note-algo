package com.wei.leetcode.f1000;


import java.util.Arrays;

public class Solution_684 {

    public static void main(String[] args) {
        Solution_684 solution = new Solution_684();
        int[][] param = {{1, 2}, {1, 3}, {2, 3}, {2, 4}};
        System.out.println("Solution = " + Arrays.toString(solution.findRedundantConnection(param)));
    }

    private int[] p;

    private int n;

    public int[] findRedundantConnection(int[][] edges) {
        n = edges.length;
        p = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            p[i] = i;
        }

        for (int[] edge : edges) {
            int a = edge[0];
            int b = edge[1];
            if (find(a) == find(b)) {
                return edge;
            }
            union(a, b);
        }
        return null;
    }

    private int find(int x) {
        if (x == p[x]) return x;
        p[x] = find(p[x]);
        return p[x];
    }

    private void union(int a, int b) {
        int rx = find(a);
        int ry = find(b);
        if (rx != ry) {
            p[rx] = ry;
        }
    }
}
