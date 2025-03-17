package com.wei.leetcode.f500;

import com.wei.leetcode.LeetCodeUtils;
import com.wei.leetcode.ListNode;

public class Solution_19 {

    public static void main(String[] args) {
        Solution_19 solution19 = new Solution_19();
        int[] nums = {1, 2, 3, 4, 5};
        ListNode listNode = LeetCodeUtils.arrayToList(nums);
        int target = 3;
        ListNode res = solution19.removeNthFromEnd(listNode, target);
        LeetCodeUtils.printList(res);
    }

    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode node = new ListNode(-1);
        node.next = head;
        ListNode fromEnd = findFromEnd(node, n);
        fromEnd.next = fromEnd.next.next;
        return node.next;
    }

    public ListNode findFromEnd(ListNode head, int k) {
        ListNode p = head;
        for (int i = 0; i < k; i++) {
            p = p.next;
        }
        ListNode p2 = head;

        while (p.next != null) {
            p = p.next;
            p2 = p2.next;
        }

        return p2;
    }
}
