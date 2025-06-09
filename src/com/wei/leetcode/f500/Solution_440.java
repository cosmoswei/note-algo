package com.wei.leetcode.f500;

class Solution_440 {

    public static void main(String[] args) {
        Solution_440 solution = new Solution_440();
        char[] nums = {'1', '2', '3', '4', '5', '6', '7'};
        int res = solution.findKthNumber(1, 2);
        System.out.println("i = " + res);
    }

    public int findKthNumber(int n, int k) {
        int node = 1;
        k--; // 访问节点 node
        while (k > 0) {
            int size = countSubtreeSize(n, node);
            if (size <= k) { // 向右，跳过 node 子树
                node++; // 访问 node 右侧兄弟节点
                k -= size; // 访问子树中的每个节点，以及新的 node 节点
            } else { // 向下，深入 node 子树
                node *= 10; // 访问 node 的第一个儿子
                k--; // 访问新的 node 节点
            }
        }
        return node;
    }

    // 逐层统计 node 子树大小
    private int countSubtreeSize(int n, int node) {
        // 子树大小不会超过 n，所以 size 用 int 类型
        // 但计算过程中的 left 和 right 会超过 int，所以用 long 类型
        int size = 0;
        long left = node;
        long right = node + 1;
        while (left <= n) {
            // 这一层的最小值是 left，最大值是 min(right, n + 1) - 1
            size += Math.min(right, n + 1) - left;
            left *= 10; // 继续，计算下一层
            right *= 10;
        }
        return size;
    }
}
