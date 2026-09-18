package main.java.com.practice.dsa.arraysandhashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequent {
    public static int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> freq = new HashMap();
        List<Integer>[] bucket = new ArrayList[nums.length + 1];
        for (int num : nums) {
            freq.put(num, freq.getOrDefault(num, 0)+1);
        }
        for (int num : freq.keySet()) {
            int count = freq.get(num);
            if (bucket[count] == null) {
                bucket[count] = new ArrayList<>();
            }

            bucket[count].add(num);
        }
        int index = 0;
        int[] result = new int[k];
        for(int i = bucket.length-1; i >= 0 && index < k; i--) {
            if(bucket[i] != null) {
                for (int num : bucket[i]) {
                    result[index ++] = num;
                    if(i == k) break;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 1, 1, 2, 2, 3};
        int k1 = 2;
        int[] ans1 = topKFrequent(nums1, k1);
        for (int n : ans1) System.out.print(n + " ");
        System.out.println(); // expected: 1 2 (order among valid top-k can vary)

        int[] nums2 = {4, 4, 4, 6, 6, 7, 7, 7, 7};
        int k2 = 2;
        int[] ans2 = topKFrequent(nums2, k2);
        for (int n : ans2) System.out.print(n + " ");
        System.out.println(); // expected: 7 4
    }
}
