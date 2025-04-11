package com.wei.leetcode.f3000;

class Solution_2843 {

    public static void main(String[] args) {
        Solution_2843 solution = new Solution_2843();
        int res = solution.countSymmetricIntegers(1, 100);
        System.out.println("res = " + res);
    }

    public int countSymmetricIntegers(int low, int high) {
        int res = 0;
        for (int i = low; i <= high; i++) {
            char[] charArray = Integer.toString(i).toCharArray();
            int n = charArray.length;
            if (n % 2 > 0) {
                continue;
            }

            int diff = 0;
            for (int j = 0; j < n / 2; j++) {
                diff += charArray[j];
            }

            for (int j = n / 2; j < n; j++) {
                diff -= charArray[j];
            }
            if (diff == 0) {
                res++;
            }
        }
        return res;
    }
}

