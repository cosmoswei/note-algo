package com.wei.leetcode.f1000;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution_638 {
    int ans = 0x3f3f3f3f;
    List<Integer> price, needs;
    List<List<Integer>> special;
    Map<Integer, Integer> map = new HashMap<>();
    int n, m;
    public int shoppingOffers(List<Integer> _price, List<List<Integer>> _special, List<Integer> _needs) {
        price = _price; special = _special; needs = _needs;
        n = price.size();
        List<Integer> temp = new ArrayList<>();
        for (int i = 0; i < n; i++) temp.add(0);
        for (int i = 0; i < n; i++) {
            List<Integer> clone = new ArrayList<>(temp);
            clone.set(i, 1);
            clone.add(price.get(i));
            special.add(clone);
        }
        m = special.size();
        for (int i = 0; i < m; i++) {
            List<Integer> x = special.get(i);
            int k = 0;
            for (int j = 0; j < n; j++) {
                int a = x.get(j), b = needs.get(j);
                if (a == 0 || b == 0) continue;
                if (a > b) {
                    k = 0;
                    break;
                }
                k = k == 0 ? b / a : Math.min(k, b / a);
            }
            map.put(i, k);
        }
        dfs(0, needs, 0);
        return ans;
    }
    void dfs(int u, List<Integer> list, int cur) {
        if (cur >= ans) return ;
        int cnt = 0;
        for (int i = 0; i < n; i++) cnt += list.get(i);
        if (cnt == 0) {
            ans = cur;
            return ;
        }
        if (u == m) return;
        List<Integer> x = special.get(u);
        out:for (int k = 0; k <= map.get(u); k++) {
            List<Integer> clist = new ArrayList<>(list);
            for (int i = 0; i < n; i++) {
                int a = x.get(i), b = clist.get(i);
                if (a * k > b) break out;
                clist.set(i, b - a * k);
            }
            dfs(u + 1, clist, cur + k * x.get(n));
        }
    }
}
