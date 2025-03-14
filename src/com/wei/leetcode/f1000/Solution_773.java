package com.wei.leetcode.f1000;

import java.util.*;

class Solution_773 {
    public static void main(String[] args) {
        int[][] board = new int[][]{{4, 1, 2}, {5, 0, 3}};
        int res = new Solution_773().slidingPuzzle(board);
        System.out.println(res);
    }

    /**
     * 给你一个 2x3 的滑动拼图，用一个 2x3 的数组 board 表示。拼图中有数字 0~5 六个数，其中数字 0 就表示那个空着的格子，你可以移动其中的数字，当 board 变为 [[1,2,3],[4,5,0]] 时，赢得游戏。
     * 请你写一个算法，计算赢得游戏需要的最少移动次数，如果不能赢得游戏，返回 -1。
     */
    public int slidingPuzzle(int[][] board) {
        String target = "123450";
        StringBuilder start = new StringBuilder();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                start.append(board[i][j]);
            }
        }
        Queue<String> queue = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        queue.offer(start.toString());
        visited.add(start.toString());
        int step = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String poll = queue.poll();
                if (target.equals(poll)) {
                    return step;
                }
                for (String neighbor : getNeighbors(poll)) {
                    if (!visited.contains(neighbor)) {
                        queue.offer(neighbor);
                        visited.add(neighbor);
                    }
                }
            }
            step++;
        }
        return -1;
    }

    private List<String> getNeighbors(String board) {
        // 记录一维字符串的相邻索引
        int[][] mapping = new int[][]{

                {1, 3},
                {0, 4, 2},
                {1, 5},
                {0, 4},
                {3, 1, 5},
                {4, 2}
        };

        int idx = board.indexOf('0');
        List<String> neighbors = new ArrayList<>();
        for (int adj : mapping[idx]) {
            String new_board = swap(board.toCharArray(), adj, idx);
            neighbors.add(new_board);
        }
        return neighbors;
    }

    private String swap(char[] chars, int i, int j) {
        char temp = chars[i];
        chars[i] = chars[j];
        chars[j] = temp;
        return new String(chars);
    }

}