package com.wei.other;

import java.util.LinkedList;

public class MyListDeque<E> {
    private LinkedList<E> list = new LinkedList<>();

    // 从队头插入元素，时间复杂度 O(1)
    void addFirst(E e) {
        list.addFirst(e);
    }

    // 从队尾插入元素，时间复杂度 O(1)
    void addLast(E e) {
        list.addLast(e);
    }

    // 从队头删除元素，时间复杂度 O(1)
    E removeFirst() {
        return list.removeFirst();
    }

    // 从队尾删除元素，时间复杂度 O(1)
    E removeLast() {
        return list.removeLast();
    }

    // 查看队头元素，时间复杂度 O(1)
    E peekFirst() {
        return list.getFirst();
    }

    // 查看队尾元素，时间复杂度 O(1)
    E peekLast() {
        return list.getLast();
    }

    public static void main(String[] args) {
        MyListDeque<Integer> deque = new MyListDeque<>();
        deque.addFirst(1);
        deque.addFirst(2);
        deque.addLast(3);
        deque.addLast(4);

        System.out.println(deque.removeFirst()); // 2
        System.out.println(deque.removeLast()); // 4
        System.out.println(deque.peekFirst()); // 1
        System.out.println(deque.peekLast()); // 3
    }
}