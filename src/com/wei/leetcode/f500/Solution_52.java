package com.wei.leetcode.f500;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_52 {

    public static void main(String[] args) {
        Solution_52 solution = new Solution_52();
        int ints = solution.solveNQueens(8);
        System.out.println("ints" + ints);
        List<List<String>> lists = solution.solveNQueens2(4);
        System.out.println("lists = " + lists);

    }

    int res = 0;

    /* 输入棋盘边长 n，返回所有合法的放置 */
    public int solveNQueens(int n) {
        // '.' 表示空，'Q' 表示皇后，初始化空棋盘
        List<String> board = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < n; j++) {
                sb.append('.');
            }
            board.add(sb.toString());
        }
        backtrack(board, 0);
        return res;
    }

    // 路径：board 中小于 row 的那些行都已经成功放置了皇后
    // 选择列表：第 row 行的所有列都是放置皇后的选择
    // 结束条件：row 超过 board 的最后一行
    void backtrack(List<String> board, int row) {
        // 触发结束条件
        if (row == board.size()) {
            res++;
            return;
        }

        int n = board.get(row).length();
        for (int col = 0; col < n; col++) {
            // 排除不合法选择
            if (!isValid(board, row, col)) {
                continue;
            }
            // 做选择
            StringBuilder sb = new StringBuilder(board.get(row));
            sb.setCharAt(col, 'Q');
            board.set(row, sb.toString());

            // 进入下一行决策
            backtrack(board, row + 1);
            // 撤销选择
            sb.setCharAt(col, '.');
            board.set(row, sb.toString());
        }
    }

    /* 是否可以在 board[row][col] 放置皇后？ */
    boolean isValid(List<String> board, int row, int col) {
        int n = board.size();

        /* 检查列是否有皇后互相冲突 */
        for (int i = 0; i < n; i++) {
            if (board.get(i).charAt(col) == 'Q') {
                return false;
            }
        }

        /* 检查右上方是否有皇后互相冲突 */
        for (int i = row - 1, j = col + 1;
             i >= 0 && j < n; i--, j++) {
            if (board.get(i).charAt(j) == 'Q') {
                return false;
            }
        }

        /* 检查左上方是否有皇后互相冲突 */
        for (int i = row - 1, j = col - 1;
             i >= 0 && j >= 0; i--, j--) {
            if (board.get(i).charAt(j) == 'Q') {
                return false;
            }
        }

        return true;
    }

    public List<List<String>> solveNQueens2(int n) {
        List<List<String>> ans = new ArrayList<>();
        int[] queens = new int[n]; // 皇后放在 (r,queens[r])
        boolean[] col = new boolean[n];
        boolean[] diag1 = new boolean[n * 2 - 1];
        boolean[] diag2 = new boolean[n * 2 - 1];
        dfs(0, queens, col, diag1, diag2, ans);
        return ans;
    }

    private void dfs(int r, int[] queens, boolean[] col, boolean[] diag1, boolean[] diag2, List<List<String>> ans) {
        int n = col.length;
        if (r == n) {
            List<String> board = new ArrayList<>(n); // 预分配空间
            for (int c : queens) {
                char[] row = new char[n];
                Arrays.fill(row, '.');
                row[c] = 'Q';
                board.add(new String(row));
            }
            ans.add(board);
            return;
        }
        // 在 (r,c) 放皇后
        for (int c = 0; c < n; c++) {
            int rc = r - c + n - 1;
            if (!col[c] && !diag1[r + c] && !diag2[rc]) { // 判断能否放皇后
                queens[r] = c; // 直接覆盖，无需恢复现场
                col[c] = diag1[r + c] = diag2[rc] = true; // 皇后占用了 c 列和两条斜线
                dfs(r + 1, queens, col, diag1, diag2, ans);
                col[c] = diag1[r + c] = diag2[rc] = false; // 恢复现场
            }
        }
    }

}
