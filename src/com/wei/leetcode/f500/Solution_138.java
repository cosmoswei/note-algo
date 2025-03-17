package com.wei.leetcode.f500;

import java.util.HashMap;

public class Solution_138 {

    public static void main(String[] args) {
        Solution_138 solution = new Solution_138();
        Node node = solution.copyRandomList(new Node(0));
        System.out.println("integers = " + node);


    }

    HashMap<Node, Node> cacheMap = new HashMap<>();

    public Node copyRandomList(Node head) {
        if (null == head) {
            return null;
        }
        if (!cacheMap.containsKey(head)) {
            Node node = new Node(head.val);
            cacheMap.put(head, node);
            node.next = copyRandomList(head.next);
            node.random = copyRandomList(head.random);
        }
        return cacheMap.get(head);
    }

    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }

        public String toString() {
            return String.valueOf(val);
        }
    }
}
