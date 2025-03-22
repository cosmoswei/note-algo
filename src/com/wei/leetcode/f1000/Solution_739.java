package com.wei.leetcode.f1000;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Solution_739 {

    public static void main(String[] args) {
        Solution_739 solution = new Solution_739();
        int[] ints = {1, 2, 3};
        System.out.println("solution.dailyTemperatures(ints) = " + Arrays.toString(solution.dailyTemperatures(ints)));
    }

    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] res = new int[n];
        Deque<Integer> st = new ArrayDeque<>();
        for (int i = 0; i < n; i++) {
            int t = temperatures[i];
            while (!st.isEmpty() && t > temperatures[st.peek()]) {
                Integer pop = st.pop();
                res[pop] = i - pop;
            }
            st.push(i);
        }
        return res;
    }
}
