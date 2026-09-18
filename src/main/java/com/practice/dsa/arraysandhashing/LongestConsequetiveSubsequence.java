package main.java.com.practice.dsa.arraysandhashing;

import java.util.HashSet;
import java.util.Set;

public class LongestConsequetiveSubsequence {
    public static int longest(int[] arr) {
        Set<Integer> set = new HashSet<>();
        if(arr == null || arr.length == 0) return 0;
        for (int a : arr) {
            set.add(a);

        }
        int longest = 0;
        for (int a : arr) {
            if(!set.contains(a-1)) {
                int currentLength = 1;
                int currentNum = a;
                while(set.contains(currentNum+1)) {
                    currentLength++;
                    currentNum = currentNum+1;
                }
                longest = Math.max(longest, currentLength);
            }
        }
        return longest;
    }

    public static void main(String[] args) {
        System.out.println(longest(new int[]{100, 4, 200, 1, 3, 2})); // 4
        System.out.println(longest(new int[]{0, 3, 7, 2, 5, 8, 4, 6, 0, 1})); // 9
        System.out.println(longest(new int[]{9, 1, 4, 7, 3, -1, 0, 5, 8, -1, 6})); // 7
        System.out.println(longest(new int[]{})); // 0
    }
}
