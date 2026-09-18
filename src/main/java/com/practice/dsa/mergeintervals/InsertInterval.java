package main.java.com.practice.dsa.mergeintervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class InsertInterval {
    public static int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> result = new ArrayList<>();
        int i = 0;
        int n = intervals.length;
        Arrays.sort(intervals, Comparator.comparingInt((int[] a) -> a[0]));
        while(i < n && intervals[i][1] < newInterval[0]) {
            result.add(intervals[i]);
            i++;
        }
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(intervals[i][0], newInterval[0]);
            newInterval[1] = Math.max(intervals[i][1], newInterval[1]);
            i++;

        }

        result.add(newInterval);
        while (i < n) {
            result.add(intervals[i]);
            i++;
        }

        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        // Test case 1: newInterval overlaps with multiple existing intervals
        int[][] intervals1 = {{1, 2}, {3, 5}, {6, 9}};
        int[] newInterval1 = {2, 5};
        int[][] result1 = insert(intervals1, newInterval1);
        System.out.println("Test 1: " + Arrays.deepToString(result1));
        // Expected: [[1, 5], [6, 9]]

        // Test case 2: newInterval doesn't overlap
        int[][] intervals2 = {{1, 5}};
        int[] newInterval2 = {2, 7};
        int[][] result2 = insert(intervals2, newInterval2);
        System.out.println("Test 2: " + Arrays.deepToString(result2));
        // Expected: [[1, 7]]

        // Test case 3: newInterval comes before all intervals
        int[][] intervals3 = {{5, 7}, {8, 10}};
        int[] newInterval3 = {1, 3};
        int[][] result3 = insert(intervals3, newInterval3);
        System.out.println("Test 3: " + Arrays.deepToString(result3));
        // Expected: [[1, 3], [5, 7], [8, 10]]

        // Test case 4: newInterval comes after all intervals
        int[][] intervals4 = {{1, 2}, {3, 5}};
        int[] newInterval4 = {6, 9};
        int[][] result4 = insert(intervals4, newInterval4);
        System.out.println("Test 4: " + Arrays.deepToString(result4));
        // Expected: [[1, 2], [3, 5], [6, 9]]

        // Test case 5: empty intervals array
        int[][] intervals5 = {};
        int[] newInterval5 = {5, 7};
        int[][] result5 = insert(intervals5, newInterval5);
        System.out.println("Test 5: " + Arrays.deepToString(result5));
        // Expected: [[5, 7]]

        // Test case 6: newInterval merges all intervals
        int[][] intervals6 = {{1, 2}, {3, 5}, {6, 9}};
        int[] newInterval6 = {1, 9};
        int[][] result6 = insert(intervals6, newInterval6);
        System.out.println("Test 6: " + Arrays.deepToString(result6));
        // Expected: [[1, 9]]
    }
}
