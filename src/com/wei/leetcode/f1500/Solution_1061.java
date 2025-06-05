package com.wei.leetcode.f1500;

class Solution_1061 {

    public static void main(String[] args) {
        Solution_1061 solution = new Solution_1061();
        String res = solution.smallestEquivalentString("", "", "");
        System.out.println("res = " + res);
    }

    public String smallestEquivalentString(String s1, String s2, String baseStr) {
        int[] fa = new int[26];
        for (int i = 0; i < 26; i++) {
            fa[i] = i;
        }

        for (int i = 0; i < s1.length(); i++) {
            merge(fa, s1.charAt(i) - 'a', s2.charAt(i) - 'a');
        }

        char[] s = baseStr.toCharArray();
        for (int i = 0; i < s.length; i++) {
            s[i] = (char) (find(fa, s[i] - 'a') + 'a');
        }
        return new String(s);
    }

    private int find(int[] fa, int x) {
        if (fa[x] != x) {
            fa[x] = find(fa, fa[x]);
        }
        return fa[x];
    }

    private void merge(int[] fa, int x, int y) {
        int fx = find(fa, x);
        int fy = find(fa, y);
        // 把大的代表元指向小的代表元
        if (fx < fy) {
            fa[fy] = fx;
        } else {
            fa[fx] = fy;
        }
    }
}


