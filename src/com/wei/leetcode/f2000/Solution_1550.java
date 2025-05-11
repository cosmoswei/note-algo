package com.wei.leetcode.f2000;

class Solution_1550 {

    public static void main(String[] args) {
        int[] nums = {1,2,34,3,4,5,7,23,12};
        System.out.println("res = "
                + new Solution_1550().threeConsecutiveOdds(nums));
    }

    public boolean threeConsecutiveOdds(int[] arr) {
        for (int i = 0; i < arr.length - 2; i++) {
            if (arr[i] % 2 != 0 && arr[i + 1] % 2 != 0 && arr[i + 2] % 2 != 0) {
                return true;
            }
        }
        return false;
    }
}

