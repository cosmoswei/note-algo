package com.wei.leetcode.f500;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Solution_347 {

    public static void main(String[] args) {
        int[] nums = new int[]{1, 1, 1, 2, 2, 3, 3, 3, 3};
        Solution_347 solution = new Solution_347();
        int[] ints = solution.topKFrequent(nums, 2);
        System.out.println("ints = " + Arrays.toString(ints));
    }

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            Integer orDefault = map.getOrDefault(num, 0);
            map.put(num, orDefault + 1);
        }
        List<Integer> collect = map.keySet().stream().sorted((o1, o2) -> map.get(o2) - map.get(o1)).collect(Collectors.toList());
        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = collect.get(i);
        }
        return res;
    }
}
