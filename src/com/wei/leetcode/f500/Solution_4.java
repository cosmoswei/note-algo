package com.wei.leetcode.f500;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Solution_4 {

    public static void main(String[] args) {
        int[] nums1 = {1, 3};
        int[] nums2 = {2};
        System.out.println("res = " + new Solution_4().findMedianSortedArrays(nums1, nums2));
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        for (int i : nums1) {
            list.add(i);
        }
        for (int i : nums2) {
            list.add(i);
        }
        list.sort(Comparator.comparingInt(o -> o));
        int size = list.size();
        if (size % 2 == 0) {
            Integer i1 = list.get(size / 2);
            Integer i2 = list.get(size / 2 - 1);
            return (double) (i1 + i2) / 2;
        } else {
            Integer i = list.get(size / 2);
            return i;
        }
    }
}
