package com.wei.leetcode.f3500;

class Solution_3240 {
    public int minFlips(int[][] a) {
        int m = a.length;
        int n = a[0].length;
        int ans = 0;
        for (int i = 0; i < m / 2; i++) {
            for (int j = 0; j < n / 2; j++) {
                int cnt1 = a[i][j] + a[i][n - 1 - j] + a[m - 1 - i][j] + a[m - 1 - i][n - 1 - j];
                ans += Math.min(cnt1, 4 - cnt1); // 全为 1 或全为 0
            }
        }

        if (m % 2 > 0 && n % 2 > 0) {
            // 正中间的数必须是 0
            ans += a[m / 2][n / 2];
        }

        int diff = 0;
        int cnt1 = 0;
        if (m % 2 > 0) {
            // 统计正中间这一排
            for (int j = 0; j < n / 2; j++) {
                if (a[m / 2][j] != a[m / 2][n - 1 - j]) {
                    diff++;
                } else {
                    cnt1 += a[m / 2][j] * 2;
                }
            }
        }
        if (n % 2 > 0) {
            // 统计正中间这一列
            for (int i = 0; i < m / 2; i++) {
                if (a[i][n / 2] != a[m - 1 - i][n / 2]) {
                    diff++;
                } else {
                    cnt1 += a[i][n / 2] * 2;
                }
            }
        }

        return ans + (diff > 0 ? diff : cnt1 % 4);
    }
}
