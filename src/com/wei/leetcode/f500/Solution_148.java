package com.wei.leetcode.f500;


import com.wei.leetcode.LeetCodeUtils;
import com.wei.leetcode.ListNode;

public class Solution_148 {

    public static void main(String[] args) {
        Solution_148 solution = new Solution_148();
        int[] nums1 = {1, 2, 5, 9, 8, 9, 3, 9, 5, 1};
        ListNode listNode1 = LeetCodeUtils.arrayToList(nums1);
        ListNode res = solution.sortList(listNode1);
        LeetCodeUtils.printList(res);
    }

    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode midNode = midNode(head);
        head = sortList(head);
        midNode = sortList(midNode);
        return mergeTwoList(head, midNode);
    }

    public ListNode midNode(ListNode head) {
        ListNode pre = head;
        ListNode fast = head;
        ListNode slow = head;
        while (fast != null && fast.next != null) {
            pre = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        assert pre != null;
        pre.next = null;
        return slow;
    }

    public ListNode mergeTwoList(ListNode listNode1, ListNode listNode2) {
        ListNode dummy = new ListNode(-1);
        ListNode cur = dummy;
        while (listNode1 != null && listNode2 != null) {
            if (listNode1.val > listNode2.val) {
                cur.next = listNode2;
                listNode2 = listNode2.next;
            } else {
                cur.next = listNode1;
                listNode1 = listNode1.next;
            }
            cur = cur.next;
        }
        cur.next = listNode1 != null ? listNode1 : listNode2;
        return dummy.next;
    }
}
