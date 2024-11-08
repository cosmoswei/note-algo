package com.wei.leetcode.f3500;

class Solution_3235 {
    public boolean canReachCorner(int X, int Y, int[][] circles) {
        boolean[] vis = new boolean[circles.length];
        for (int i = 0; i < circles.length; i++) {
            long x = circles[i][0], y = circles[i][1], r = circles[i][2];
            if (inCircle(x, y, r, 0, 0) || // 圆 i 包含矩形左下角
                inCircle(x, y, r, X, Y) || // 圆 i 包含矩形右上角
                // 圆 i 是否与矩形上边界/左边界相交相切
                !vis[i] && (x <= X && Math.abs(y - Y) <= r ||
                            y <= Y && x <= r ||
                            y > Y && inCircle(x, y, r, 0, Y)) && dfs(i, X, Y, circles, vis)) {
                return false;
            }
        }
        return true;
    }

    // 判断点 (x,y) 是否在圆 (ox,oy,r) 内
    private boolean inCircle(long ox, long oy, long r, long x, long y) {
        return (ox - x) * (ox - x) + (oy - y) * (oy - y) <= r * r;
    }

    private boolean dfs(int i, int X, int Y, int[][] circles, boolean[] vis) {
        long x1 = circles[i][0], y1 = circles[i][1], r1 = circles[i][2];
        // 圆 i 是否与矩形右边界/下边界相交相切
        if (y1 <= Y && Math.abs(x1 - X) <= r1 ||
            x1 <= X && y1 <= r1 ||
            x1 > X && inCircle(x1, y1, r1, X, 0)) {
            return true;
        }
        vis[i] = true;
        for (int j = 0; j < circles.length; j++) {
            long x2 = circles[j][0], y2 = circles[j][1], r2 = circles[j][2];
            // 在两圆相交相切的前提下，点 A 是否严格在矩形内
            if (!vis[j] &&
                (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2) <= (r1 + r2) * (r1 + r2) &&
                x1 * r2 + x2 * r1 < (r1 + r2) * X &&
                y1 * r2 + y2 * r1 < (r1 + r2) * Y &&
                dfs(j, X, Y, circles, vis)) {
                return true;
            }
        }
        return false;
    }
}
