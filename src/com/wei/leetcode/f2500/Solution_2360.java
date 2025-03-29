package com.wei.leetcode.f2500;

class Solution_2360 {

    /**
     * 作者：灵茶山艾府
     * 链接：https://leetcode.cn/problems/longest-cycle-in-a-graph/solutions/1710828/nei-xiang-ji-huan-shu-zhao-huan-li-yong-pmqmr/
     * 来源：力扣（LeetCode）
     * 著作权归作者所有。商业转载请联系作者获得授权，非商业转载请注明出处。
     */
    public int longestCycle(int[] edges) {
        int n = edges.length;
        int ans = -1;
        int curTime = 1; // 当前时间
        int[] visTime = new int[n]; // 首次访问 x 的时间
        for (int i = 0; i < n; i++) {
            int x = i;
            int startTime = curTime; // 本轮循环的开始时间
            while (x != -1 && visTime[x] == 0) { // 没有访问过 x
                visTime[x] = curTime++; // 记录访问 x 的时间
                x = edges[x]; // 访问下一个节点
            }
            if (x != -1 && visTime[x] >= startTime) { // x 在本轮循环中访问了两次，说明 x 在环上
                ans = Math.max(ans, curTime - visTime[x]); // 前后两次访问 x 的时间差，即为环长
            }
        }
        return ans; // 如果没有找到环，返回的是 ans 的初始值 -1
    }


}
