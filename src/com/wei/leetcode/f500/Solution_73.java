package com.wei.leetcode.f500;

class Solution_73 {


    public static void main(String[] args) {
        new Solution_73().setZeroes(new int[][]{{1, 1, 1}, {1, 0, 1}, {1, 1, 1}});
    }

    public void setZeroes(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int[] lZero = new int[n];
        int[] rZero = new int[m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.println("i = " + i + ", j = " + j);
                if (matrix[i][j] == 0) {
                    lZero[i] = 1;
                    rZero[j] = 1;
                    System.out.println("matrix[i][j] = " + matrix[i][j]);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (lZero[i] == 1 || rZero[j] == 1) {
                    matrix[i][j] = 0;
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.println("matrix[i][j] = " + matrix[i][j]);
            }}
    }
}