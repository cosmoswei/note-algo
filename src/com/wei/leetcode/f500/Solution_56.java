package com.wei.leetcode.f500;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution_56 {

    public static void main(String[] args) {
        Solution_56 solution = new Solution_56();
        int[][] merge = solution.merge(new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}});
        System.out.println("integers = " + Arrays.deepToString(merge));
    }

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (p, q) -> p[0] - q[0]);
        List<int[]> ans = new ArrayList<>();

        for (int[] interval : intervals) {
            int size = ans.size();
            if (size > 0 && interval[0] <= ans.get(size - 1)[1]) {
                ans.get(size - 1)[1] = Math.max(ans.get(size - 1)[1], interval[1]);
            } else {
                ans.add(interval);
            }
        }
        return ans.toArray(new int[ans.size()][]);
    }

}
