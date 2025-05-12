package com.wei.leetcode.f2500;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution_2094 {

    public static void main(String[] args) {
        int[] nums = {2, 1, 3, 0};
        int[] res = new Solution_2094().findEvenNumbers(nums);
        System.out.println("res = "
                + Arrays.toString(res));
    }

    public int[] findEvenNumbers(int[] digits) {
        int[] cnt = new int[10];
        for (int digit : digits) {
            cnt[digit]++;
        }
        List<Integer> res = new ArrayList<>();
        dfs(0, 0, cnt, res);
        return res.stream().mapToInt(i -> i).toArray();
    }

    private void dfs(int i, int x, int[] cnt, List<Integer> res) {
        if (i == 3) {
            res.add(x);
            return;
        }
        for (int i1 = 0; i1 < 10; i1++) {
            if (cnt[i1] > 0 && (i == 0 && i1 > 0 || i == 1 || i == 2 && i1 % 2 == 0)) {
                cnt[i1]--;
                dfs(i + 1, x * 10 + i1, cnt, res);
                cnt[i1]++;
            }
        }
    }


}

