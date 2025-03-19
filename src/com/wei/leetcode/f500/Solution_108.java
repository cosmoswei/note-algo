package com.wei.leetcode.f500;

import com.wei.leetcode.TreeNode;

public class Solution_108 {

    public static void main(String[] args) {
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST2(nums, 0, nums.length - 1);
    }

    TreeNode sortedArrayToBST2(int[] nums, int l, int r) {
        if (l > r) {
            return null;
        }
        int mid = (l+r) / 2;
        TreeNode treeNode = new TreeNode(nums[mid]);
        treeNode.left = sortedArrayToBST2(nums, l, mid - 1);
        treeNode.right = sortedArrayToBST2(nums, mid + 1, r);
        return treeNode;
    }
}
