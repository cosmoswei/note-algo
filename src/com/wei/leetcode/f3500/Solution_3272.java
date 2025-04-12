package com.wei.leetcode.f3500;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class Solution_3272 {


    public static void main(String[] args) {
        Solution_3272 solution = new Solution_3272();
        long res = solution.countGoodIntegers(3, 5);
        System.out.println("res = " + res);
    }

    public long countGoodIntegers(int n, int k) {
        // 在 1*1^n 内有多少个可以被k整除的回文数？ 这个数可以重新排列
        int[] arr = new int[n + 1];
        arr[0] = 1;
        for (int i = 1; i <= n; i++) {
            arr[i] = arr[i - 1] * i;
        }

        long res = 0;
        Set<String> set = new HashSet<>();
        int base = (int) Math.pow(10, (n - 1) / 2);
        for (int i = base; i < base * 10; i++) {
            String s = Integer.toString(i);
            s += new StringBuilder(s).reverse().substring(n % 2);
            if (Long.parseLong(s) % k > 0) {
                continue;
            }
            char[] charArray = s.toCharArray();
            Arrays.sort(charArray);
            if (!set.add(new String(charArray))) {
                continue;
            }
            int[] cnt = new int[10];
            for (char c : charArray) {
                cnt[c - '0']++;
            }
            int num = (n - cnt[0]) * arr[n - 1];
            for (int i1 : cnt) {
                num /= arr[i1];
            }
            res += num;
        }

        return res;
    }
}
