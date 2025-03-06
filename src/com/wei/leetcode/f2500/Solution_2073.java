package com.wei.leetcode.f2500;


import java.util.ArrayDeque;
import java.util.Queue;

public class Solution_2073 {

    public static void main(String[] args) {
        int[] strings1 = {2, 3, 2};
        Solution_2073 solution = new Solution_2073();
        int i = solution.timeRequiredToBuy(strings1, 2);
        System.out.println("i = " + i);
    }

    public int timeRequiredToBuy(int[] tickets, int k) {
        int time = 0;
        Queue<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < tickets.length; i++) {
            queue.offer(i);
        }
        while (!queue.isEmpty()) {
            Integer poll = queue.poll();
            time++;
            tickets[poll]--;
            if (poll == k && tickets[poll] == 0) {
                return time;
            }
            if (tickets[poll] == 0) {
                continue;
            }
            queue.offer(poll);
        }
        return time;
    }
}
