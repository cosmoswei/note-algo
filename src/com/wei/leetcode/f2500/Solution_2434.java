package com.wei.leetcode.f2500;

class Solution_2434 {

    public static void main(String[] args) {
        int[] nums = {2, 1, 3, 0};
        String res = new Solution_2434().robotWithString("nums, 2, 2");
        System.out.println("res = "
                + res);
    }

    public String robotWithString(String S) {
        char[] s = S.toCharArray();
        int n = s.length;
        // 计算后缀最小值
        char[] sufMin = new char[n + 1];
        sufMin[n] = Character.MAX_VALUE;
        for (int i = n - 1; i >= 0; i--) {
            sufMin[i] = (char) Math.min(sufMin[i + 1], s[i]);
        }

        char[] ans = s;
        char[] st = sufMin;
        int idx = 0;
        int top = -1;
        for (int i = 0; i < n; i++) {
            st[++top] = s[i];
            while (top >= 0 && st[top] <= sufMin[i + 1]) {
                ans[idx++] = st[top--];
            }
        }
        return new String(ans);
    }
}



