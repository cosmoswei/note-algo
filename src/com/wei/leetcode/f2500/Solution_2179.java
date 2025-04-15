package com.wei.leetcode.f2500;

class Solution_2179 {
    public static void main(String[] args) {
        Solution_2179 solution = new Solution_2179();
        int[] ints1 = {2, 0, 1, 3};
        int[] ints2 = {0, 1, 2, 3};
        long res = solution.goodTriplets(ints1, ints2);
        System.out.println("res = " + res);
    }

    public long goodTriplets(int[] nums1, int[] nums2) {
        long res = 0;
        int n = nums1.length;
        int[] p = new int[n];
        for (int i = 0; i < n; i++) {
            p[nums1[i]] = i;
        }
        FenwickTree tree = new FenwickTree(n);
        for (int i = 0; i < n - 1; i++) {
            int y = p[nums2[i]];
            int less = tree.pre(y);
            res += (long) less * (n - 1 - y - (i - less));
            tree.update(y + 1, 1);
        }
        return res;
    }

    static class FenwickTree {
        private final int[] tree;

        public FenwickTree(int n) {
            tree = new int[n + 1];
        }

        public void update(int i, long var) {
            for (; i < tree.length; i += i & -i) {
                tree[i] += var;
            }
        }

        public int pre(int i) {
            int res = 0;
            for (; i > 0; i &= i - 1) {
                res += tree[i];
            }
            return res;
        }
    }
}