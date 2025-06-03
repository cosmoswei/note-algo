package com.wei.leetcode.f1500;

class Solution_1298 {

    public static void main(String[] args) {
        Solution_1298 solution = new Solution_1298();
        int[] ints = {5, 5, 5, 5};
    }

    private int ans = 0;

    public int maxCandies(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes) {
        int[] hasKey = status; // 把开着的盒子当作有钥匙
        boolean[] hasBox = new boolean[status.length];
        for (int x : initialBoxes) {
            hasBox[x] = true;
        }

        for (int x : initialBoxes) {
            if (hasBox[x] && hasKey[x] == 1) { // 注意 dfs 中会修改 hasBox
                dfs(x, candies, keys, containedBoxes, hasKey, hasBox);
            }
        }
        return ans;
    }

    private void dfs(int x, int[] candies, int[][] keys, int[][] containedBoxes, int[] hasKey, boolean[] hasBox) {
        ans += candies[x];
        hasBox[x] = false; // 避免找到钥匙后重新访问开着的盒子

        // 找到钥匙，打开盒子（说明我们先找到盒子，然后找到钥匙）
        for (int y : keys[x]) {
            hasKey[y] = 1;
            if (hasBox[y]) {
                dfs(y, candies, keys, containedBoxes, hasKey, hasBox);
            }
        }

        // 找到盒子，使用钥匙（说明我们先找到钥匙，然后找到盒子）
        for (int y : containedBoxes[x]) {
            hasBox[y] = true;
            if (hasKey[y] == 1) {
                dfs(y, candies, keys, containedBoxes, hasKey, hasBox);
            }
        }
    }
}
