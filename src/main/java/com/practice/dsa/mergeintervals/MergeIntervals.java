package main.java.com.practice.dsa.mergeintervals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeIntervals {
    public static int[][] merge(int[][] intervals) {
        int startInterval = intervals[0][0];
        int endInterval = intervals[0][1];

        if (intervals.length <= 1) {
            return intervals;
        }

        // Sort by start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> result = new ArrayList<>();

        for (int i = 1; i < intervals.length; i++) {
            int currentStartInterval = intervals[i][0];
            int currentEndInterval = intervals[i][1];
            if(endInterval >= currentStartInterval) {
                endInterval = Math.max(endInterval, currentEndInterval);
            } else {
                result.add(new int[]{startInterval, endInterval});
                startInterval = currentStartInterval;
                endInterval = currentEndInterval;
            }
        }
        result.add(new int[] {startInterval, endInterval});
        return result.toArray(new int[result.size()][]);
    }

    public static void main(String[] args) {
        int[][] intervals = {
                {1, 3},
                {2, 6},
                {8, 10},
                {15, 18}
        };

        int[][] merged = merge(intervals);
        System.out.println(Arrays.deepToString(merged));
    }
}
