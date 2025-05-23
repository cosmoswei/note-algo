package com.wei.leetcode.f3500;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution_3068 {
    public static void main(String[] args) {
        Solution_3068 solution = new Solution_3068();
        int[] nums1 = {3, 0, 1};
        int[][] nums2 = {{3, 0, 1}};
        long i = solution.maximumValueSum(nums1, 2, nums2);
        System.out.println("i = " + i);
    }

    public long maximumValueSum(int[] nums, int k, int[][] edges) {
        int n = nums.length;
        List<Integer>[] g = new ArrayList[n];
        Arrays.setAll(g, i -> new ArrayList<>());
        for (int[] e : edges) {
            int x = e[0];
            int y = e[1];
            g[x].add(y);
            g[y].add(x);
        }
        return dfs(0, -1, g, nums, k)[0];
    }

    private long[] dfs(int x, int fa, List<Integer>[] g, int[] nums, int k) {
        long f0 = 0;
        long f1 = Long.MIN_VALUE; // f[x][0] 和 f[x][1]
        for (int y : g[x]) {
            if (y != fa) {
                long[] r = dfs(y, x, g, nums, k);
                long t = Math.max(f1 + r[0], f0 + r[1]);
                f0 = Math.max(f0 + r[0], f1 + r[1]);
                f1 = t;
            }
        }
        return new long[]{Math.max(f0 + nums[x], f1 + (nums[x] ^ k)),
                Math.max(f1 + nums[x], f0 + (nums[x] ^ k))};
    }
}
