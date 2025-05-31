package com.wei.leetcode.f1000;

import java.util.ArrayList;
import java.util.List;

class Solution_909 {

    public static void main(String[] args) {
        int[][] board = {{3, 2, 1}, {0, 3, 3}};
        Solution_909 solution = new Solution_909();
        int i = solution.snakesAndLadders(board);
        System.out.println("i = " + i);
    }

    // 更快的写法见【Java 数组】
    public int snakesAndLadders(int[][] board) {
        int n = board.length;
        boolean[] vis = new boolean[n * n + 1];
        vis[1] = true; // 题目保证起点没有蛇梯，不写也可以
        List<Integer> q = new ArrayList<>();
        q.add(1); // 起点
        for (int step = 0; !q.isEmpty(); step++) {
            List<Integer> tmp = q;
            q = new ArrayList<>();
            for (int x : tmp) {
                if (x == n * n) { // 终点
                    return step;
                }
                for (int y = x + 1; y <= Math.min(x + 6, n * n); y++) {
                    int r = (y - 1) / n;
                    int c = (y - 1) % n;
                    if (r % 2 > 0) {
                        c = n - 1 - c; // 奇数行从右到左
                    }
                    int nxt = board[n - 1 - r][c];
                    if (nxt < 0) {
                        nxt = y;
                    }
                    if (!vis[nxt]) {
                        vis[nxt] = true; // 有环的情况下，避免死循环
                        q.add(nxt);
                    }
                }
            }
        }
        return -1; // 无法到达终点
    }
}