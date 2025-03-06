package com.wei.leetcode;

public class DoublyListNode {
    int val;
    DoublyListNode next;
    DoublyListNode pre;

    DoublyListNode(int n) {
        this.val = n;
    }

    static void printNode(DoublyListNode doublyListNode) {
        DoublyListNode pre = doublyListNode.pre;
        if (pre != null) {
            System.out.print(" p.pre = " + pre.val);
        } else {
            System.out.print(" p.pre =  ");
        }
        System.out.print(" p = " + doublyListNode.val);
        DoublyListNode next = doublyListNode.next;
        if (next != null) {
            System.out.print(" p.next = " + next.val);
        } else {
            System.out.print(" p.next =  ");
        }
        System.out.println();
    }

    static DoublyListNode createList(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }
        DoublyListNode head = new DoublyListNode(arr[0]);
        DoublyListNode cur = head;
        for (int i = 1; i < arr.length; i++) {
            DoublyListNode node = new DoublyListNode(arr[i]);
            cur.next = node;
            node.pre = cur;
            cur = cur.next;
        }

        return head;
    }
}
