package com.wei.leetcode.f2500;

import java.util.*;

class Solution_2176 {

    public static void main(String[] args) {
        Solution_2176 solution = new Solution_2176();
        int[] nums = new int[]{3, 1, 2, 2, 2, 1, 3};
        int res = solution.countPairs(nums, 2);
        System.out.println("res = " + res);
    }

    private static final int MX = 101;
    private static final List<Integer>[] divisors = new ArrayList[MX];

    static {
        Arrays.setAll(divisors, i -> new ArrayList<>());
        for (int i = 1; i < MX; i++) {
            for (int i1 = i; i1 < MX; i1 += i) {
                divisors[i1].add(i);
            }
        }
    }

    public int countPairs(int[] nums, int k) {
        int res = 0;
        // value index
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (i > 0 && num == nums[0]) {
                res++;
            }
            int k2 = k / gcg(k, i);
            res += map.getOrDefault(k2 << 10 | num, 0);
            for (Integer integer : divisors[i]) {
                map.merge(integer << 10 | num, 1, Integer::sum);
            }
        }
        return res;
    }

    private int gcg(int k, int i) {
        while (k != 0) {
            int tmp = i % k;
            i = k;
            k = tmp;
        }
        return i;
    }

}