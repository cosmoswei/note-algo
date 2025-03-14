package com.wei.leetcode.f500;

import java.util.Arrays;

public class Solution_322 {

    public static void main(String[] args) {
        Solution_322 solution = new Solution_322();
        int[] nums = {186, 419, 83, 408};
        int target = 6249;
        System.out.println(solution.coinChange(nums, target));
    }

    int coinChange(int[] coins, int amount) {
        // 题目要求的最终结果是 dp(amount)
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for (int i = 1; i < dp.length; i++) {
            for (int coin : coins) {
                if (i - coin < 0) {
                    continue;
                }
                dp[i] = Math.min(dp[i], dp[i - coin] + 1);
            }
        }
        return dp[amount] == amount + 1 ? -1 : dp[amount];
    }

    int[] memo;

    int coinChange0(int[] coins, int amount) {
        memo = new int[amount + 1];
        // 备忘录初始化为一个不会被取到的特殊值，代表还未被计算
        Arrays.fill(memo, -666);
        // 题目要求的最终结果是 dp(amount)
        return dp(coins, amount);
    }

    int dp(int[] coins, int amount) {
        if (amount == 0) {
            return 0;
        }
        if (amount < 0) {
            return -1;
        }
        int i = memo[amount];

        if (i != -666) {
            return i;
        }
        int res = Integer.MAX_VALUE;
        for (int coin : coins) {
            int dp = dp(coins, amount - coin);
            if (dp == -1) {
                continue;
            }
            res = Math.min(dp + 1, res);
        }
        memo[amount] = (res == Integer.MAX_VALUE) ? -1 : res;
        return memo[amount];
    }
}
