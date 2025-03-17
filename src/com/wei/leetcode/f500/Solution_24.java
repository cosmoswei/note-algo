package com.wei.leetcode.f500;

import com.wei.leetcode.LeetCodeUtils;
import com.wei.leetcode.ListNode;

public class Solution_24 {

    public static void main(String[] args) {
        int[] int3 = {3, 3, 6, 9, 11, 23, 24};
        ListNode listNode = LeetCodeUtils.arrayToList(int3);
        Solution_24 solution23 = new Solution_24();
        listNode = solution23.swapPairs(listNode);
        LeetCodeUtils.printList(listNode);
    }

    public ListNode swapPairs(ListNode head) {
        ListNode p = new ListNode(-1);
        p.next = head;
        ListNode temp = p;
        while (temp.next != null && temp.next.next != null) {
            ListNode node1 = temp.next;
            ListNode node2 = temp.next.next;
            temp.next = node2;
            node1.next = node2.next;
            node2.next = node1;
            temp = node1;
        }
        return p.next;
    }
}
