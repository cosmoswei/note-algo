package com.wei.leetcode.f2500;


import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class Solution_2071 {

    public static void main(String[] args) {
        int[] tasks = {3, 2, 1};
        int[] workers = {0, 3, 3};
        Solution_2071 solution = new Solution_2071();
        int i = solution.maxTaskAssign(tasks, workers, 1, 1);
        System.out.println("i = " + i);
    }

    public int maxTaskAssign(int[] tasks, int[] workers, int pills, int strength) {
        Arrays.sort(tasks);
        Arrays.sort(workers);
        int left = 0;
        int right = Math.min(tasks.length, workers.length) + 1;
        while (left + 1 < right) {
            int mid = (right + left) >>> 1;
            if (check(tasks, workers, pills, strength, mid)) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return left;
    }

    private boolean check(int[] tasks, int[] workers, int pills, int strength, int k) {
        Deque<Integer> validTasks = new ArrayDeque<>();
        int i = 0;
        for (int j = workers.length - k; j < workers.length; j++) {
            int w = workers[j];
            while (i < k && tasks[i] <= w + strength) {
                validTasks.addLast(tasks[i]);
                i++;
            }
            if (validTasks.isEmpty()) {
                return false;
            }
            if (w >= validTasks.peekFirst()) {
                validTasks.pollFirst();
                continue;
            }
            if (pills == 0) {
                return false;
            }
            pills--;
            validTasks.pollLast();
        }
        return true;
    }
}
