package com.wei.leetcode.f3000;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution_2610 {
    public List<List<Integer>> findMatrix(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.merge(num, 1, Integer::sum);
        }
        while (!map.isEmpty()) {
            ArrayList<Integer> arrayList = new ArrayList<>(map.keySet());
            res.add(arrayList);
            for (Integer i : arrayList) {
                Integer i1 = map.get(i) - 1;
                if (i1 == 0) {
                    map.remove(i);
                } else {
                    map.put(i, i1);
                }
            }
        }
        return res;
    }
}