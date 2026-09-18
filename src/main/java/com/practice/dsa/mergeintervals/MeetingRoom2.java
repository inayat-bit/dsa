package main.java.com.practice.dsa.mergeintervals;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class MeetingRoom2 {

    public static int minRoom(int[][] meetings) {
        Arrays.sort(meetings, Comparator.comparingInt((int[] a) -> a[0]));
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int end = meetings[0][1];
        minHeap.offer(end);
        for (int i = 1; i < meetings.length; i++) {
            if(!minHeap.isEmpty() && minHeap.peek() <= meetings[i][0]) {
                minHeap.poll();
            }
            minHeap.offer(meetings[i][1]);
        }
        return minHeap.size();
    }

    public static void main(String[] args) {
        int[][] meetings1 = {{0, 30}, {5, 10}, {15, 20}};   // overlap -> 2
        int[][] meetings2 = {{7, 10}, {2, 4}};              // no overlap -> 1
        int[][] meetings3 = {{1, 5}, {8, 9}, {8, 9}};       // one overlap at same start -> 2
        int[][] meetings4 = {{1, 4}, {2, 5}, {7, 9}};       // first two overlap -> 2
        int[][] meetings5 = {{6, 7}, {2, 4}, {8, 12}};      // fully non-overlap unsorted -> 1
        int[][] meetings6 = {{1, 10}, {2, 7}, {3, 19}, {8, 12}, {10, 20}, {11, 30}}; // heavy overlap -> 4

        System.out.println("Test 1 expected 2, got: " + minRoom(meetings1));
        System.out.println("Test 2 expected 1, got: " + minRoom(meetings2));
        System.out.println("Test 3 expected 2, got: " + minRoom(meetings3));
        System.out.println("Test 4 expected 2, got: " + minRoom(meetings4));
        System.out.println("Test 5 expected 1, got: " + minRoom(meetings5));
        System.out.println("Test 6 expected 4, got: " + minRoom(meetings6));
    }
}
