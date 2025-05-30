package com.wei.leetcode.f2500;

import java.util.Arrays;

class Solution_2359 {

    public static void main(String[] args) {
        int[] nums = {2, 1, 3, 0};
        int res = new Solution_2359().closestMeetingNode(nums, 2, 2);
        System.out.println("res = "
                + res);
    }

    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int[] dis1 = calcDis(edges, node1);
        int[] dis2 = calcDis(edges, node2);

        int n = edges.length;
        int minDis = n;
        int ans = -1;
        for (int i = 0; i < n; i++) {
            int d = Math.max(dis1[i], dis2[i]);
            if (d < minDis) {
                minDis = d;
                ans = i;
            }
        }
        return ans;
    }

    private int[] calcDis(int[] edges, int x) {
        int n = edges.length;
        int[] dis = new int[n];
        Arrays.fill(dis, n); // n 表示无法到达或者尚未访问的节点
        // 从 x 出发，直到无路可走（x=-1）或者重复访问节点（dis[x]<n）
        for (int d = 0; x >= 0 && dis[x] == n; x = edges[x]) {
            dis[x] = d++;
        }
        return dis;
    }
}

