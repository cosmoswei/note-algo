package com.wei.leetcode.f1000;

import java.util.LinkedList;
import java.util.Queue;

public class Solution_994 {

    public static void main(String[] args) {
        Solution_994 solution = new Solution_994();
        int[][] grid = {
                {1, 1, 0, 0, 0},
                {1, 1, 0, 0, 0},
                {0, 0, 1, 0, 0},
                {0, 0, 0, 1, 1}
        };
        System.out.println("Solution = " + solution.orangesRotting(grid));
    }

    public int orangesRotting(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        Queue<int[]> queue = new LinkedList<>();
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 1) {
                    count++;
                }
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                }
            }
        }

        int round = 0;
        while (count > 0 && !queue.isEmpty()) {
            round++;
            int x = queue.size();
            for (int i = 0; i < x; i++) {
                int[] poll = queue.poll();
                int r = poll[0];
                int c = poll[1];
                if (r - 1 >= 0 && grid[r - 1][c] == 1) {
                    grid[r - 1][c] = 2;
                    count--;
                    queue.add(new int[]{r - 1, c});
                }

                if (r + 1 < n && grid[r + 1][c] == 1) {
                    grid[r + 1][c] = 2;
                    count--;
                    queue.add(new int[]{r + 1, c});
                }

                if (c - 1 >= 0 && grid[r][c - 1] == 1) {
                    grid[r][c - 1] = 2;
                    count--;
                    queue.add(new int[]{r, c - 1});
                }
                if (c + 1 < m && grid[r][c + 1] == 1) {
                    grid[r][c + 1] = 2;
                    count--;
                    queue.add(new int[]{r, c + 1});
                }
            }
        }
        if (count > 0) {
            return -1;
        } else {
            return round;
        }
    }
}
