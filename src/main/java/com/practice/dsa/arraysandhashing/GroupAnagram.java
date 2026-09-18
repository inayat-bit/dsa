package main.java.com.practice.dsa.arraysandhashing;

import java.util.*;

public class GroupAnagram {
    public static List<List<String>> groupAnagram(List<String> words) {

        Map<String, List<String>> map =  new HashMap<>();
        for(String str : words) {
            char[] freq = new char[26];
            for(char c : str.toCharArray()) {
                freq[c - 'a'] ++;
            }
            String key = Arrays.toString(freq);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(str);
        }
        return new ArrayList<>(map.values());
    }

    public static void main(String[] args) {
        // Test case 1: standard anagram groups
        List<String> words1 = Arrays.asList("eat", "tea", "tan", "ate", "nat", "bat");
        System.out.println(groupAnagram(words1));
        // Expected: [[eat, tea, ate], [tan, nat], [bat]]

        // Test case 2: single word
        List<String> words2 = Arrays.asList("a");
        System.out.println(groupAnagram(words2));
        // Expected: [[a]]

        // Test case 3: empty string
        List<String> words3 = Arrays.asList("");
        System.out.println(groupAnagram(words3));
        // Expected: [[]]

        // Test case 4: all same anagrams
        List<String> words4 = Arrays.asList("abc", "bca", "cab");
        System.out.println(groupAnagram(words4));
        // Expected: [[abc, bca, cab]]
    }
}
