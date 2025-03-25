package com.wei.leetcode.f500;

import java.util.ArrayDeque;
import java.util.Deque;

class Solution_32 {

    public static void main(String[] args) {
        Solution_32 solution128 = new Solution_32();
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        Object res = solution128.longestValidParentheses("()())))())()()((())))");
        System.out.println(res);
    }

    public int longestValidParentheses(String s) {
        int res = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    res = Math.max(res, i - stack.peek());
                }
            }
        }

        return res;
    }
}