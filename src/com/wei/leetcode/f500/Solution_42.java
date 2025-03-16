package com.wei.leetcode.f500;

public class Solution_42 {

    public static void main(String[] args) {
        int[] nums = {4, 2, 0, 3, 2, 5};
        System.out.println("trap = " + trap2(nums));
    }

    static public int trap(int[] height) {
        int res = 0;
        int n = height.length;
        if (n == 0) {
            return res;
        }
        int[] lMax = new int[height.length];
        lMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            lMax[i] = Math.max(height[i], lMax[i - 1]);
        }

        int[] rMax = new int[height.length];
        rMax[n - 1] = height[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            rMax[i] = Math.max(height[i], rMax[i + 1]);
        }

        for (int i = 0; i < n; i++) {
            res += Math.min(lMax[i], rMax[i]) - height[i];
        }
        return res;
    }

    static public int trap2(int[] height) {
        int n = height.length;
        int res = 0;
        // 计算前缀最大值
        int preMax = 0;
        int subMax = 0;
        int left = 0, right = n - 1;
        while (left < right) {
            preMax = Math.max(preMax, height[left]);
            subMax = Math.max(subMax, height[right]);
            res += preMax < subMax ? preMax - height[left++] : subMax - height[right--];
        }
        // 结果 = 各节点的min(前缀最大值，后缀最大值)-数组高度之和
        return res;
    }
}
