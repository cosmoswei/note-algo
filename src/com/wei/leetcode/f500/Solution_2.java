package com.wei.leetcode.f500;


import com.wei.leetcode.LeetCodeUtils;
import com.wei.leetcode.ListNode;

public class Solution_2 {

    public static void main(String[] args) {
        Solution_2 solution = new Solution_2();
        int[] nums1 = {1, 9, 9, 9, 9, 9, 9, 9, 9, 9};
        int[] nums2 = {9};
        ListNode listNode1 = LeetCodeUtils.arrayToList(nums1);
        ListNode listNode2 = LeetCodeUtils.arrayToList(nums2);
        ListNode res = solution.addTwoNumbers1(listNode1, listNode2);
        LeetCodeUtils.printList(res);
    }

    public ListNode addTwoNumbers1(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(); // 哨兵节点
        ListNode cur = dummy;
        int carry = 0; // 进位
        while (l1 != null || l2 != null || carry != 0) { // 有一个不是空节点，或者还有进位，就继续迭代
            if (l1 != null) {
                carry += l1.val; // 节点值和进位加在一起
                l1 = l1.next; // 下一个节点
            }
            if (l2 != null) {
                carry += l2.val; // 节点值和进位加在一起
                l2 = l2.next; // 下一个节点
            }
            cur = cur.next = new ListNode(carry % 10); // 每个节点保存一个数位
            carry /= 10; // 新的进位
        }
        return dummy.next; // 哨兵节点的下一个节点就是头节点
    }

    public ListNode addTwoNumbers0(ListNode l1, ListNode l2) {
        ListNode head = null, tail = null;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int n1 = l1 != null ? l1.val : 0;
            int n2 = l2 != null ? l2.val : 0;
            int sum = n1 + n2 + carry;
            if (head == null) {
                head = tail = new ListNode(sum % 10);
            } else {
                tail.next = new ListNode(sum % 10);
                tail = tail.next;
            }
            carry = sum / 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry > 0) {
            tail.next = new ListNode(carry);
        }
        return head;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int num1 = getNum(l1);
        int num2 = getNum(l2);
        int i = num1 + num2;
        if (i == 0) {
            return new ListNode(0);
        }
        ListNode listNode = new ListNode(-1);
        ListNode p = listNode;
        while (i != 0) {
            int val = i % 10;
            ListNode listNode1 = new ListNode();
            listNode1.val = val;
            p.next = listNode1;
            p = p.next;
            i /= 10;
        }
        return listNode.next;
    }

    private static int getNum(ListNode l1) {
        int cnt = 0;
        int num = 0;
        while (l1 != null) {
            int val = l1.val;
            int a = 1;
            for (int i = 0; i < cnt; i++) {
                a = a * 10;
            }
            val *= a;
            num += val;
            cnt++;
            l1 = l1.next;
        }
        return num;
    }
}
