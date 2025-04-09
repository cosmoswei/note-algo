package com.wei.leetcode.f3500;

import java.util.HashSet;
import java.util.Set;

class Solution_3375 {

    public static void main(String[] args) {
        Solution_3375 solution = new Solution_3375();
        int res = solution.minOperations(new int[]{5, 2, 5, 4, 5}, 2);
        System.out.println("res = " + res);
    }

    private int minOperations(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int anInt : nums) {
            if (anInt < k) {
                return -1;
            } else {
                if (anInt != k) {
                    set.add(anInt);
                }
            }
        }
        return set.size();
    }


}
