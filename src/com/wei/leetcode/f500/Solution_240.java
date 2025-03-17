package com.wei.leetcode.f500;

public class Solution_240 {

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 4, 7, 11, 15}, {2, 5, 8, 12, 19}, {3, 6, 9, 16, 22}, {10, 13, 14, 17, 24}, {18, 21, 23, 26, 30}};
        System.out.println("res = " + new Solution_240().searchMatrix(matrix, 22));
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        for (int i = 0; i < m; i++) {
            int[] ints = matrix[i];
            int search = search(ints, target);
            if (search != -1) {
                return true;
            }
        }

        return false;
    }

    private int search(int[] ints, int target) {
        int left = 0;
        int right = ints.length - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            int anInt = ints[mid];
            if (anInt == target) {
                return mid;
            } else if (anInt > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return -1;
    }

    public boolean searchMatrix0(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == target) {
                    return true;
                }
            }
        }

        return false;
    }
}





