package main.java.com.practice.dsa.slidingwindow;

import java.util.HashSet;

public class LongestUniqueSubstring {
    private static int longestUniqueSubstring(String string) {
        int left = 0;
        int right = 0;
        int max = 0;
        HashSet<Character> set = new HashSet<>();
        while(right < string.length()) {
            while (set.contains(string.charAt(right))) {
                set.remove(string.charAt(right));
                left++;
            }
            set.add(string.charAt(right));
            max = Math.max(max, right - left + 1);
            right++;
        }
        return max;
    }
    public static void main(String[] args) {
        String string = "abcabcbb";
        System.out.println(longestUniqueSubstring(string));
    }
}
