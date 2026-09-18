package main.java.com.practice.dsa.mergeintervals;

import java.util.Arrays;
import java.util.Comparator;

public class MeetingRoom {
    public static boolean isAttendMeeting(int[][] meetings) {
        Arrays.sort(meetings, Comparator.comparingInt((int[] a) -> a[0]));
        int end = meetings[0][1];

        for (int i = 1; i < meetings.length; i++) {
            if(end > meetings[i][0]) return false;
            end = meetings[i][1];
        }
        return true;
    }

    public static void main(String[] args) {
        int[][] meetings1 = {{0, 30}, {35, 40}, {50, 60}}; // no overlap
        int[][] meetings2 = {{0, 30}, {5, 10}, {15, 20}};  // overlap
        int[][] meetings3 = {{7, 10}, {2, 4}};             // unsorted, no overlap
        int[][] meetings4 = {{1, 5}, {5, 8}};              // touching boundary

        System.out.println("Test 1 (expected true):  " + isAttendMeeting(meetings1));
        System.out.println("Test 2 (expected false): " + isAttendMeeting(meetings2));
        System.out.println("Test 3 (expected true):  " + isAttendMeeting(meetings3));
        System.out.println("Test 4 (expected true):  " + isAttendMeeting(meetings4));
    }
}
