package com.wei.leetcode.f500;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution_118 {

    public static void main(String[] args) {
        System.out.println("res = " + new Solution_118().generate(8));
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        res.add(Collections.singletonList(1));
        for (int i = 1; i < numRows; i++) {
            List<Integer> row = new ArrayList<>(i + 1);
            row.add(1);
            for (int j = 1; j < i; j++) {
                row.add(res.get(i - 1).get(j - 1) + res.get(i - 1).get(j));
            }
            row.add(1);
            res.add(row);
        }
        return res;
    }
}
