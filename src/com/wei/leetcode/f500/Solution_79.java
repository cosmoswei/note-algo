package com.wei.leetcode.f500;

public class Solution_79 {

    public static void main(String[] args) {
        Solution_79 solution22 = new Solution_79();
        boolean exist = solution22.exist(new char[][]{}, "3");
        System.out.println("exist = " + exist);
    }

    public boolean exist(char[][] board, String word) {
        char[] wo = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (dfs(i, j, 0, board, wo)) {
                    return true;
                }
            }
        }
        return false;
    }

    private static final int[][] DIRS = {{0, -1}, {0, 1}, {-1, 0}, {1, 0}};

    private boolean dfs(int i, int j, int k, char[][] board, char[] word) {
        if (board[i][j] != word[k]) {
            return false;
        }

        if (k == word.length - 1) {
            return true;
        }

        board[i][j] = 0;

        for (int[] dir : DIRS) {
            int x = i + dir[0];
            int y = j + dir[1];
            if (0 <= x && x < board.length && 0 <= y && y < board[x].length && dfs(x, y, k + 1, board, word)) {
                return true;
            }
        }

        board[i][j] = word[k];

        return false;
    }
}
