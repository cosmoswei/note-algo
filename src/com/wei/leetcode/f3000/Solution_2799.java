package com.wei.leetcode.f3000;


import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution_2799 {

    public static void main(String[] args) {
        Solution_2799 solution = new Solution_2799();
        int res = solution.countCompleteSubarrays(new int[]{5, 5, 5, 5});
        System.out.println("res = " + res);
    }

    public int countCompleteSubarrays(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int mum : nums) {
            set.add(mum);
        }
        int k = set.size();
        Map<Integer, Integer> map = new HashMap<>();
        int res = 0;
        int left = 0;
        for (int num : nums) {
            map.merge(num, 1, Integer::sum);
            while (map.size() == k) {
                int out = nums[left];
                if (map.merge(out, -1, Integer::sum) == 0) {
                    map.remove(out);
                }
                left++;
            }
            res += left;
        }
        return res;
    }
}
