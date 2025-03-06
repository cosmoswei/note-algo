package com.wei.leetcode;

public class DoublyListNodeUtil {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 2, 3, 4, 5};
        int i = 0;
        // 模拟环形数组，这个循环永远不会结束
        while (i < arr.length) {
            System.out.println(arr[i]);
            i = (i + 1) % arr.length;
        }

        DoublyListNode listNode = DoublyListNode.createList(new int[]{1, 2, 3, 4, 5, 6});
        listNode = headAdd(listNode, 0);
        listNode = tailAdd(listNode, 10);

        listNode = indexAdd(listNode, 8, 1);
        listNode = indexDel(listNode, 1);
        traversal(listNode);
    }

    private static DoublyListNode indexDel(DoublyListNode listNode, int index) {
        if (null == listNode) {
            return null;
        }

        if (index <= 0) {
            DoublyListNode next = listNode.next;
            next.pre = null;
            return next;
        }

        DoublyListNode cur = listNode;
        // 找到前面的
        for (int i = 0; i < index - 1; i++) {
            if (cur == null) {
                continue;
            }
            cur = cur.next;
        }
        if (cur == null) {
            return listNode;
        }
        DoublyListNode toDelete = cur.next;
        cur.next = toDelete.next;
        toDelete.next.pre = cur;
        return listNode;
    }

    private static DoublyListNode indexAdd(DoublyListNode listNode, int var, int index) {
        DoublyListNode newNode = new DoublyListNode(var);
        if (listNode == null) {
            return newNode;
        }
        DoublyListNode cur = listNode;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }
        newNode.next = cur.next;
        cur.next = newNode;
        newNode.pre = cur;
        return listNode;
    }

    private static DoublyListNode tailAdd(DoublyListNode listNode, int var) {
        // 在双链表头部插入新节点 0
        DoublyListNode newTail = new DoublyListNode(var);
        if (listNode == null) {
            return newTail;
        }

        DoublyListNode tail = null;
        for (DoublyListNode p = listNode; p != null; p = p.next) {
            tail = p;
        }
        tail.next = newTail;
        newTail.pre = tail;
        return listNode;
    }

    public static void traversal(DoublyListNode doublyListNode) {
        for (DoublyListNode p = doublyListNode; p != null; p = p.next) {
            DoublyListNode.printNode(p);
        }
    }

    public static DoublyListNode headAdd(DoublyListNode doublyListNode, int var) {
        // 在双链表头部插入新节点 0
        DoublyListNode newHead = new DoublyListNode(var);
        newHead.next = doublyListNode;
        doublyListNode.pre = newHead;
        return newHead;
    }
}
