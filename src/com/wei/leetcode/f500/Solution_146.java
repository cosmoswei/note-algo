package com.wei.leetcode.f500;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

class Solution_146 {


    public static void main(String[] args) {
        Solution_146 solution = new Solution_146();
        solution.testCapacityOne();
        solution.testLRUCacheOperations();
        solution.testOverwriteExistingKey();
    }

    void testLRUCacheOperations() {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);

        assertEquals(1, cache.get(1)); // 访问 1，应该返回 1
        cache.put(3, 3); // 淘汰 2
        assertEquals(-1, cache.get(2)); // 2 应该被移除
        assertEquals(3, cache.get(3)); // 访问 3，应该返回 3

        cache.put(4, 4); // 淘汰 1
        assertEquals(-1, cache.get(1)); // 1 应该被移除
        assertEquals(3, cache.get(3)); // 3 仍然存在
        assertEquals(4, cache.get(4)); // 4 应该存在
    }

    private void assertEquals(int i, int i1) {
        if (i == i1) {
            return;
        }
        throw new RuntimeException();
    }

    void testCapacityOne() {
        LRUCache cache = new LRUCache(1);
        cache.put(1, 1);
        assertEquals(1, cache.get(1));
        cache.put(2, 2); // 1 应该被淘汰
        assertEquals(-1, cache.get(1));
        assertEquals(2, cache.get(2));
    }

    void testOverwriteExistingKey() {
        LRUCache cache = new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.put(1, 10); // 更新 key 1
        assertEquals(10, cache.get(1));
    }
}

class LRUCache {

    private static class Node {
        int key, value;
        Node prev, next;

        Node(int k, int v) {
            key = k;
            value = v;
        }
    }

    private final int capacity;
    private final Node dummy = new Node(0, 0);
    private final Map<Integer, Node> map = new ConcurrentHashMap<>();

    public LRUCache(int capacity) {
        this.capacity = capacity;
        dummy.prev = dummy;
        dummy.next = dummy;
    }

    public synchronized int get(int key) {
        Node node = getNode(key);
        return node == null ? -1 : node.value;
    }

    public synchronized void put(int key, int value) {
        Node node = getNode(key);
        if (node != null) {
            node.value = value;
            return;
        }

        Node node1 = new Node(key, value);
        map.put(key, node1);
        pushFront(node1);
        if (map.size() > capacity) {
            Node prev = dummy.prev;
            map.remove(prev.key);
            remove(prev);
        }
    }

    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void pushFront(Node node) {
        node.prev = dummy;
        node.next = dummy.next;
        node.prev.next = node;
        node.next.prev = node;
    }

    private Node getNode(int k) {
        boolean b = map.containsKey(k);
        if (!b) {
            return null;
        }
        Node node = map.get(k);
        remove(node);
        pushFront(node);
        return node;
    }
}