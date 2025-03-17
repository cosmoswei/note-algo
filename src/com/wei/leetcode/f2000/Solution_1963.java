package com.wei.leetcode.f2000;

class Solution_1963 {
    public int minSwaps(String s) {
        int res = 0;
        char[] charArray = s.toCharArray();
        int c = 0;
        int j = charArray.length - 1;
        for (char b : charArray) {
            if (b == '[') {
                c++;
            } else if (c > 0) {
                c--;
            } else {
                while (charArray[j] == ']') {
                    j--;
                }
                charArray[j] = ']';
                res++;
                c++;
            }
        }
        return res;
    }
}

