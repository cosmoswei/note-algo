package com.wei.leetcode.f2000;

class Solution_1534 {

    public static void main(String[] args) {
        Solution_1534 solution = new Solution_1534();
        int[] nums1 = {3, 0, 1, 1, 9, 7};
        int i = solution.countGoodTriplets(nums1, 7, 2, 3);
        System.out.println("i = " + i);
    }

    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int res = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++) {
                    if (Math.abs(arr[i] - arr[j]) <= a && Math.abs(arr[j] - arr[k]) <= b && Math.abs(arr[k] - arr[i]) <= c) {
                        res++;
                    }
                }
            }
        }
        return res;
    }

}

