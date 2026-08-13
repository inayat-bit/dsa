package main.java.com.practice.dsa.slidingwindow;

import java.util.HashMap;

public class AtMostKSubArray {
    private static int atMostKSubArray(int[] arr, int k) {
        int left = 0;
        int right = 0;
        int count = 0;
        int i = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        while (right < arr.length) {

            // Add current element
            map.put(arr[right], map.getOrDefault(arr[right], 0) + 1);

            // Shrink until valid
            while (map.size() > k) {
                map.put(arr[left], map.get(arr[left]) - 1);

                if (map.get(arr[left]) == 0) {
                    map.remove(arr[left]);
                }

                left++;
            }

            // Count all valid subarrays ending at right
            count += right - left + 1;

            right++;
        }
        return count;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,1,2,3};
        int k = 2;
        System.out.println(atMostKSubArray(arr, k) - atMostKSubArray(arr, k-1));
    }

}
