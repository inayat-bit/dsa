package main.java.com.practice.dsa.priorityqueue;

import java.util.Collections;
import java.util.PriorityQueue;

public class MedianOfDataStream {

    private static PriorityQueue<Integer> maxHeap, minHeap;
    public MedianOfDataStream() {
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();
    }
    public static void addNum(int num) {
        maxHeap.offer(num);
        if(!minHeap.isEmpty() && maxHeap.peek() > minHeap.peek()) {
            minHeap.offer(maxHeap.poll());
        }

        if(minHeap.size() > maxHeap.size() + 1) {
            maxHeap.offer(minHeap.poll());
        } else if(minHeap.size()  + 1 < maxHeap.size()) {
            minHeap.offer(maxHeap.poll());
        }

    }

    public static double median() {
        if(maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        } else if (maxHeap.size() < minHeap.size()) {
            return minHeap.peek();
        } else {
            return (double) (maxHeap.peek() + minHeap.peek()) /2;
        }

    }

    public static void main(String[] args) {
        new MedianOfDataStream(); // initialize heaps

        int[] stream = {5, 15, 1, 3};
        for (int num : stream) {
            addNum(num);
            System.out.println("After adding " + num + ", median = " + median());
        }
    }

}
