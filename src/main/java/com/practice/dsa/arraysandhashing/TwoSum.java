package main.java.com.practice.dsa.arraysandhashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static int[] twoSum(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];
        for(int i = 0; i < arr.length; i++) {
            if(map.containsKey(target - arr[i])) {
                result[0] = map.get(target - arr[i]);
                result[1] = i;
                return result;
            } else {
                map.put(arr[i], i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {2, 7, 11, 15};
        int target = 9;

        int[] result = twoSum(arr, target);

        System.out.println("Indices: " + Arrays.toString(result));
        if (result[0] != -1) {
            System.out.println("Values: [" + arr[result[0]] + ", " + arr[result[1]] + "]");
        } else {
            System.out.println("No valid pair found.");
        }
    }
}
