package com.wei.leetcode.f500;

import java.util.PriorityQueue;

public class Soulution_294 {

}

class MedianFinder {

    PriorityQueue<Integer> minHeap = new PriorityQueue<>();
    PriorityQueue<Integer> maxHeap = new PriorityQueue<>((x, y) -> y - x);

    public MedianFinder() {
    }

    public void addNum(Integer num) {
        if (minHeap.isEmpty() || num > minHeap.peek()) {
            minHeap.offer(num);
        } else {
            maxHeap.offer(num);
        }
        // -- 维护中位数数量，大堆和小堆堆顶元素是有序的，那堆元素数量超出预期，就移除并放到另一个堆里面
        if (minHeap.size() > maxHeap.size() + 1) {
            maxHeap.offer(minHeap.poll());
        } else if (maxHeap.size() > minHeap.size()) {
            minHeap.offer(maxHeap.poll());
        }
    }

    public double findMedian() {
        if (minHeap.size() == maxHeap.size()) {
            return (minHeap.peek() + maxHeap.peek()) / 2.0;
        } else {
            return minHeap.peek();
        }
    }
}
