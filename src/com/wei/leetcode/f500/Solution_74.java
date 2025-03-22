package com.wei.leetcode.f500;

class Solution_74 {


    public static void main(String[] args) {
        boolean b = new Solution_74().searchMatrix(new int[][]{{1, 3}}, 3);
        System.out.println("b = " + b);
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        for (int i = 0; i < matrix.length; i++) {
            int[] ints = matrix[i];
            if (ints[0] <= target && target <= ints[ints.length - 1]) {
                int left = 0;
                int right = ints.length - 1;
                while (left <= right) {
                    int mid = left + (right - left) / 2;
                    if (ints[mid] == target) {
                        return true;
                    }
                    if (ints[mid] < target) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                }
            }
        }
        return false;
    }
}