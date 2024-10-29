package com.wei.leetcode.f3500;

import java.util.ArrayList;
import java.util.List;

class Solution3211 {
    public List<String> validStrings(int n) {
        List<String> ans = new ArrayList<>();
        int mask = (1 << n) - 1;
        for (int x = 0; x < (1 << n); x++) {
            if (((x >> 1) & x) == 0) {
                int i = x ^ mask;
                // 一种生成前导零的写法：在 i 前面插入 1<<n，转成字符串后再去掉插入的 1<<n
                ans.add(Integer.toBinaryString((1 << n) | i).substring(1));
            }
        }
        return ans;
    }
}
