package main.java.com.practice.dsa.arraysandhashing;

import java.util.HashSet;
import java.util.Set;

public class Duplicate {

    public static boolean containsDuplicate(int[] arr) {
        Set<Integer> set = new HashSet<>();
        for(int a : arr) {
            if(set.contains(a)) return true;
            set.add(a);
        }
        return false;
    }

    public static void main(String[] args) {
        // Test case 1: contains duplicate
        int[] arr1 = {1, 2, 3, 1};
        System.out.println(containsDuplicate(arr1)); // true

        // Test case 2: no duplicate
        int[] arr2 = {1, 2, 3, 4};
        System.out.println(containsDuplicate(arr2)); // false

        // Test case 3: all duplicates
        int[] arr3 = {1, 1, 1, 1};
        System.out.println(containsDuplicate(arr3)); // true

        // Test case 4: empty array
        int[] arr4 = {};
        System.out.println(containsDuplicate(arr4)); // false
    }
}
