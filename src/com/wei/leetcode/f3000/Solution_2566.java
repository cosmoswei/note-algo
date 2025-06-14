package com.wei.leetcode.f3000;

class Solution_2566 {

    public static void main(String[] args) {
        Solution_2566 solution = new Solution_2566();
        int res = solution.minMaxDifference(2231111);
        System.out.println("res = " + res);
    }

    public int minMaxDifference(int num) {
        String s = String.valueOf(num);
        int mx = num;
        for (char c : s.toCharArray()) {
            if (c != '9') { // 第一个不等于 9 的字符
                mx = Integer.parseInt(s.replace(c, '9')); // 替换成 9
                break;
            }
        }
        // 第一个不等于 0 的字符，替换成 0
        int mn = Integer.parseInt(s.replace(s.charAt(0), '0'));
        return mx - mn;
    }
}
