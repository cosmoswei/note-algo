package com.wei.leetcode.f1000;

import java.util.HashMap;
import java.util.Map;

class Solution_781 {

    public static void main(String[] args) {
        Solution_781 solution = new Solution_781();
        int[] nums = {1, 1, 2};
        int i = solution.numRabbits(nums);
        System.out.println("i = " + i);
    }

    public int numRabbits(int[] answers) {
        int res = 0;
        Map<Integer, Integer> map = new HashMap<>();
        for (int answer : answers) {
            map.merge(answer, 1, Integer::sum);
        }
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            Integer key = entry.getKey();
            Integer value = entry.getValue();
            res += (key + value) / (key + 1) * (key + 1);
        }
        return res;
    }
}
