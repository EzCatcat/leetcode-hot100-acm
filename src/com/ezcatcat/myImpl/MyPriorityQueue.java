package com.ezcatcat.myImpl;

import java.util.PriorityQueue;

/**
 * 优先级队列，本质是最小堆。这里先实现最小堆
 * @Author: EzCatcat
 * @Date: 2025/4/4 16:41
 */
public class MyPriorityQueue {


    public static void main(String[] args) {
        MyPriorityQueue queue = new MyPriorityQueue(10);
        queue.offer(13);
        queue.print();
        queue.offer(2);
        queue.print();
        queue.offer(32);
        queue.print();
        queue.offer(4);
    //    queue.offer(1);
        queue.print();


        final PriorityQueue<Integer> q = new PriorityQueue<>(10);
        q.offer(13);
        q.offer(2);
        q.offer(32);
        q.offer(4);
        while (!q.isEmpty()) {
            System.out.println(q.poll());
        }
    }








    private int[] queue;
    private int capacity;
    private int size;

    public MyPriorityQueue(int capacity) {
        this.capacity = capacity;
        this.queue = new int[capacity];
        this.size = 0;
    }

    /**
     * 添加元素。
     * 1. 元素为0，直接添加
     * 2. 不为空，需要添加到尾部，再调整
     * @param value
     */
    public void offer(int value) {
        if (size == capacity) {
            throw new RuntimeException("队列满了");
        }
        if (size == 0) {
            queue[size++] = value;
            return;
        }
        queue[size] = value;
        siftUp();
        size++;
    }

    /**
     * 比较父节点和子节点，如果子节点小于父节点，则交换位置，直到父节点小于子节点。
     */
    private void siftUp() {
        int i = size;
        while (i > 0) {
            int parent = (i - 1) / 2;
            if (queue[parent] > queue[i]) {
                swap(parent, i);
                i = parent;
            } else {
                break;
            }
        }
    }
    private void swap(int i, int j) {
        int temp = queue[i];
        queue[i] = queue[j];
        queue[j] = temp;
    }

    /**
     * 移出头节点，将尾部节点移到头节点，再调整。
     * 1. 一个元素，不用调整
     * 2. 两个元素，调整
     * 3. 多个元素，将尾部移动，和左右节点小的比较并交换，不断下去
     * @return
     */
    private int poll() {
        if (size == 0) {
            throw new RuntimeException("队列为空");
        }
        if (size == 1) {
            return queue[--size];
        }
        if (size == 2) {
            int temp = queue[0];
            queue[0] = queue[1];
            size--;
            return temp;
        }
        int temp = queue[0];
        queue[0] = queue[--size];
        siftDown();
        return temp;
    }

    /**
     * 比较左右节点和父节点，如果子节点小于父节点，则交换位置，直到父节点小于子节点。
     */
    private void siftDown() {
        int i = 0;
        while (i < size) {
            int left = i * 2 + 1;
            int right = i * 2 + 2;
            if (queue[left] < queue[right]) {
                if (queue[left] < queue[i]) {
                    swap(left, i);
                    i = left;
                }
            } else {
                if (queue[right] < queue[i]) {
                    swap(right, i);
                    i = right;
                }
            }
        }
    }

    private void print() {
        System.out.println("===========================");
        for (int i = 0; i < size; i++) {
            System.out.print(queue[i] + " ");
        }
        System.out.println();
        System.out.println();
    }
}
