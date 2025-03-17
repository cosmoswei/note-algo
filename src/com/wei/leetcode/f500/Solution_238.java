package com.wei.leetcode.f500;

import java.util.Arrays;

public class Solution_238 {

    public static void main(String[] args) {
        System.out.println("new Solution_238() = "
                + Arrays.toString(new Solution_238().productExceptSelf(new int[]{1, 2, 3, 4, 5, 6, 7})));

    }

    public int[] productExceptSelf(int[] nums) {
        int[] res = new int[nums.length];
        int[] pre = new int[nums.length];
        pre[0] = 1;
        for (int i = 1; i < nums.length; i++) {
            pre[i] = pre[i - 1] * nums[i - 1];
        }
        int[] sub = new int[nums.length];
        sub[nums.length - 1] = 1;
        for (int i = nums.length - 2; i >= 0; i--) {
            sub[i] = nums[i + 1] * sub[i + 1];
        }
        for (int i = 0; i < nums.length; i++) {
            res[i] = sub[i] * pre[i];
        }
        return res;
    }

    public int[] productExceptSelf0(int[] nums) {
        int[] res = new int[nums.length];
        int a = 1;
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res.length; j++) {
                int num = nums[j];
                if (i != j) {
                    a = a * num;
                }
            }
            res[i] = a;
            a = 1;
        }
        return res;
    }
}
