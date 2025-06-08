package com.wei.leetcode.f500;

import java.util.ArrayList;
import java.util.List;

public class Solution_386 {

    public static void main(String[] args) {
        List<Integer> res = new Solution_386().lexicalOrder(20);
        System.out.println("res = " + res);
    }

    List<Integer> ans = new ArrayList<>();

    public List<Integer> lexicalOrder(int n) {
        for (int i = 1; i <= 9; i++) dfs(i, n);
        return ans;
    }

    void dfs(int cur, int limit) {
        if (cur > limit) return;
        ans.add(cur);
        for (int i = 0; i <= 9; i++) dfs(cur * 10 + i, limit);
    }

}


