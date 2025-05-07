package com.wei.leetcode.f3500;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

class Solution_3341 {

    public static void main(String[] args) {
        int[][] nums = {{3, 2, 1, 4, 5}};
        System.out.println("res = "
                + new Solution_3341().minTimeToReach(nums));
    }

    private static final int[][] DIRS = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};

    public int minTimeToReach(int[][] moveTime) {
        int n = moveTime.length;
        int m = moveTime[0].length;
        int[][] dis = new int[n][m];
        for (int[] di : dis) {
            Arrays.fill(di, Integer.MAX_VALUE);
        }
        dis[0][0] = 0;
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        pq.add(new int[]{0, 0, 0});
        while (true) {
            int[] p = pq.poll();
            int d = p[0], i = p[1], j = p[2];
            if (i == n - 1 && j == m - 1) {
                return d;
            }
            if (d > dis[i][j]) {
                continue;
            }
            int time = (i + j) % 2 + 1;
            for (int[] q : DIRS) {
                int x = i + q[0], y = j + q[1];
                if (0 <= x && x < n && 0 <= y && y < m) {
                    int newDis = Math.max(d, moveTime[x][y]) + time;
                    if (newDis < dis[x][y]) {
                        dis[x][y] = newDis;
                        pq.add(new int[]{newDis, x, y});
                    }
                }
            }
        }
    }
}