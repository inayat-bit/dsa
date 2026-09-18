package main.java.com.practice.dsa.arraysandhashing;

import java.util.HashMap;
import java.util.Map;

public class ValidAnagram {

    public static boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap<>();
        char[] ch = s.toCharArray();
        for (char value : ch) {
            map.put(value, map.getOrDefault(value, 0) + 1);
        }
        char[] dh = t.toCharArray();
        for (char c : dh) {
            if (!map.containsKey(c)) {
                return false;
            }
            int frequencyCount = map.get(c) -1;
            if (frequencyCount == 0) {
                map.remove(c);
            } else {
                map.put(c, frequencyCount);
            }
        }
        return map.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram")); // true
        System.out.println(isAnagram("rat", "car"));         // false
    }
}
