package com.wei.leetcode.f500;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_368 {

    public static void main(String[] args) {
        Solution_368 solution = new Solution_368();
        int[] nums = {1, 2, 3};
        List<Integer> res = solution.largestDivisibleSubset(nums);
        System.out.println("res = " + res);
    }

    public List<Integer> largestDivisibleSubset(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int[] f = new int[n];
        int[] from = new int[n];
        Arrays.fill(from, -1);
        int maxI = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] % nums[j] == 0 && f[j] > f[i]) {
                    f[i] = f[j];
                    from[i] = j;
                }
            }
            f[i]++;
            if (f[i] > f[maxI]) {
                maxI = i;
            }
        }

        List<Integer> path = new ArrayList<>(f[maxI]);
        for (int i = maxI; i >= 0; i = from[i]) {
            path.add(nums[i]);
        }
        return path;
    }
}


