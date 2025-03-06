package com.wei.leetcode;

public class CycleArrayTest {
    public static void main(String[] args) {
        // 测试添加和删除头部元素
        testAddFirstAndRemoveFirst();
        // 测试添加和删除尾部元素
        testAddLastAndRemoveLast();
        // 测试头部和尾部同时操作
        testAddFirstAndAddLast();
        // 测试扩容和缩容
        testResize();
        // 测试删除头部和尾部元素
        testRemoveFirstAndRemoveLast();
        // 测试 isEmpty 和 isFull
        testIsEmptyAndIsFull();
        // 测试边界情况
        testEdgeCases();

        System.out.println("所有测试通过！");
    }

    private static void testAddFirstAndRemoveFirst() {
        CycleArray<Integer> cycleArray = new CycleArray<>();
        cycleArray.addFirst(1);
        cycleArray.addFirst(2);
        cycleArray.addFirst(3);

        assertEqual(cycleArray.size(), 3);
        assertEqual(cycleArray.getFirst(), 3);
        assertEqual(cycleArray.getLast(), 1);

        cycleArray.removeFirst();
        assertEqual(cycleArray.size(), 2);
        assertEqual(cycleArray.getFirst(), 2);
        assertEqual(cycleArray.getLast(), 1);

        cycleArray.removeFirst();
        assertEqual(cycleArray.size(), 1);
        assertEqual(cycleArray.getFirst(), 1);
        assertEqual(cycleArray.getLast(), 1);

        cycleArray.removeFirst();
        assertTrue(cycleArray.isEmpty());
    }

    private static void testAddLastAndRemoveLast() {
        CycleArray<Integer> cycleArray = new CycleArray<>();
        cycleArray.addLast(1);
        cycleArray.addLast(2);
        cycleArray.addLast(3);

        assertEqual(cycleArray.size(), 3);
        assertEqual(cycleArray.getFirst(), 1);
        assertEqual(cycleArray.getLast(), 3);

        cycleArray.removeLast();
        assertEqual(cycleArray.size(), 2);
        assertEqual(cycleArray.getFirst(), 1);
        assertEqual(cycleArray.getLast(), 2);

        cycleArray.removeLast();
        assertEqual(cycleArray.size(), 1);
        assertEqual(cycleArray.getFirst(), 1);
        assertEqual(cycleArray.getLast(), 1);

        cycleArray.removeLast();
        assertTrue(cycleArray.isEmpty());
    }

    private static void testAddFirstAndAddLast() {
        CycleArray<Integer> cycleArray = new CycleArray<>();
        cycleArray.addFirst(1);
        cycleArray.addLast(2);
        cycleArray.addFirst(3);
        cycleArray.addLast(4);

        assertEqual(cycleArray.size(), 4);
        assertEqual(cycleArray.getFirst(), 3);
        assertEqual(cycleArray.getLast(), 4);
    }

    private static void testResize() {
        CycleArray<Integer> cycleArray = new CycleArray<>(2);
        cycleArray.addLast(1);
        cycleArray.addLast(2);
        cycleArray.addLast(3);
        cycleArray.addLast(4);

        assertEqual(cycleArray.size(), 4);
        assertEqual(cycleArray.getFirst(), 1);
        assertEqual(cycleArray.getLast(), 4);
    }

    private static void testRemoveFirstAndRemoveLast() {
        CycleArray<Integer> cycleArray = new CycleArray<>();
        cycleArray.addLast(1);
        cycleArray.addLast(2);
        cycleArray.addLast(3);

        cycleArray.removeFirst();
        cycleArray.removeLast();

        assertEqual(cycleArray.size(), 1);
        assertEqual(cycleArray.getFirst(), 2);
        assertEqual(cycleArray.getLast(), 2);
    }

    private static void testIsEmptyAndIsFull() {
        CycleArray<Integer> cycleArray = new CycleArray<>(3);
        assertTrue(cycleArray.isEmpty());
        assertFalse(cycleArray.isFull());

        cycleArray.addLast(1);
        cycleArray.addLast(2);
        cycleArray.addLast(3);

        assertFalse(cycleArray.isEmpty());
        assertTrue(cycleArray.isFull());
    }

    private static void testEdgeCases() {
        CycleArray<Integer> cycleArray = new CycleArray<>();

        try {
            cycleArray.removeFirst();
            assert false : "应该抛出 IllegalStateException";
        } catch (IllegalStateException e) {
            // 预期的异常
        }

        try {
            cycleArray.removeLast();
            assert false : "应该抛出 IllegalStateException";
        } catch (IllegalStateException e) {
            // 预期的异常
        }

        try {
            cycleArray.getFirst();
            assert false : "应该抛出 IllegalStateException";
        } catch (IllegalStateException e) {
            // 预期的异常
        }

        try {
            cycleArray.getLast();
            assert false : "应该抛出 IllegalStateException";
        } catch (IllegalStateException e) {
            // 预期的异常
        }
    }

    private static void assertEqual(Object actual, Object expected) {
        if (!actual.equals(expected)) {
            throw new AssertionError("测试失败！预期值: " + expected + ", 实际值: " + actual);
        }
    }

    private static void assertTrue(boolean condition) {
        if (!condition) {
            throw new AssertionError("测试失败！条件为 false");
        }
    }

    private static void assertFalse(boolean condition) {
        if (condition) {
            throw new AssertionError("测试失败！条件为 true");
        }
    }
}