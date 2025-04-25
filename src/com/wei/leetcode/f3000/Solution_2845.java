package com.wei.leetcode.f3000;

import java.util.ArrayList;
import java.util.List;

class Solution_2845 {
    public static void main(String[] args) {
        Solution_2845 solution = new Solution_2845();
        int[] ints = {3, 2, 4};
        List<Integer> integers = new ArrayList<>();
        for (int anInt : ints) {
            integers.add(anInt);
        }
        long res = solution.countInterestingSubarrays(integers, 2, 1);
        System.out.println("res = " + res);
    }

    public long countInterestingSubarrays(List<Integer> nums, int modulo, int k) {
        long res = 0;
        int n = nums.size();
        int[] sum = new int[n + 1];
        for (int i = 0; i < n; i++) {
            sum[i + 1] = sum[i] + (nums.get(i) % modulo == k ? 1 : 0);
        }
        int[] cnt = new int[Math.min(n + 1, modulo)];
        for (int s : sum) {
            if (s >= k) {
                res += cnt[(s - k) % modulo];
            }
            cnt[s % modulo]++;
        }
        return res;
    }
}

