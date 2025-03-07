package com.wei.leetcode.f3000;

import java.util.HashMap;
import java.util.Map;

class Solution_2588 {
    public long beautifulSubarrays(int[] nums) {
        long ans = 0;
        int s = 0;
        Map<Integer, Integer> cnt = new HashMap<>(nums.length + 1); // 预分配空间
        cnt.put(0, 1);
        for (int x : nums) {
            s ^= x;
            int c = cnt.getOrDefault(s, 0);
            ans += c;
            cnt.put(s, c + 1);
        }
        return ans;
    }
}

