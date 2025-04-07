package com.wei.leetcode.f500;


import java.util.Arrays;

public class Solution_416 {


    public static void main(String[] args) {
        int[] arrays = {3, 9, 20, 2, 2, 15, 7};
        Solution_416 solution = new Solution_416();
        Object res = solution.canPartition2(arrays);
        System.out.println("res = " + res);
    }

    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        int n = nums.length;
        int target = sum / 2;
        boolean[][] dp = new boolean[nums.length + 1][target + 1];
        for (int i = 1; i <= n; i++) {
            dp[i][0] = true;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= target; j++) {
                if (j - nums[i - 1] < 0) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
        }
        return dp[n][target];
    }

    public boolean canPartition2(int[] nums) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        int n = nums.length;
        int target = sum / 2;
        int[][] memo = new int[n][sum / 2 + 1];
        for (int[] ints : memo) {
            Arrays.fill(ints, -1);
        }
        return dfs(n - 1, sum / 2, nums, memo);
    }

    private boolean dfs(int i, int j, int[] nums, int[][] memo) {

        if (i < 0) {
            return j == 0;
        }

        if (memo[i][j] != -1) {
            return memo[i][j] == 1;
        }

        boolean res = j >= nums[i] && dfs(i - 1, j - nums[i], nums, memo) || dfs(i - 1, j, nums, memo);

        memo[i][j] = res ? 1 : 0;

        return res;
    }
}

