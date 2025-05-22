package com.wei.leetcode.f3500;

import java.util.Arrays;
import java.util.PriorityQueue;

class Solution_3362 {

    public static void main(String[] args) {
        Solution_3362 solution = new Solution_3362();
        int[] nums1 = {3, 0, 1};
        int[][] nums2 = {{3, 0, 1}};
        System.out.println("solution = " + solution.maxRemoval(nums1, nums2));
    }

    public int maxRemoval(int[] nums, int[][] queries) {
        Arrays.sort(queries, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        int n = nums.length;
        int[] diff = new int[n + 1];
        int sumD = 0;
        int j = 0;
        for (int i = 0; i < n; i++) {
            sumD += diff[i];
            // 维护左端点 <= i 的区间
            while (j < queries.length && queries[j][0] <= i) {
                pq.add(queries[j][1]);
                j++;
            }
            // 选择右端点最大的区间
            while (sumD < nums[i] && !pq.isEmpty() && pq.peek() >= i) {
                sumD++;
                diff[pq.poll() + 1]--;
            }
            if (sumD < nums[i]) {
                return -1;
            }
        }
        return pq.size();
    }

}