package main.java.com.practice.dsa.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public static List<int[]> sum(int[] arr) {
        Arrays.sort(arr);
        List<int[]> result = new ArrayList<>();
        for (int i = 0; i < arr.length - 2; i++) {
            if(i > 0 && arr[i] == arr[i-1]) continue;
            int left = i+1;
            int right = arr.length - 1;
            while (left < right) {
                int[] nums = new int[3];
                int sum = arr[i] + arr[left] + arr[right];
                if(sum == 0) {
                    nums[0] = arr[i];
                    nums[1] = arr[left];
                    nums[2] = arr[right];
                    result.add(nums);
                    right--;
                    left++;
                    while (left < right && arr[left] == arr[left-1]) left++;
                    while(left < right && arr[right] == arr[right+1]) right --;
                } else if (sum < 0) left++;
                  else right--;
            }

        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {-1, 0, 1, 2, -1, -4};

        List<int[]> triplets = sum(arr);
        for (int[] triplet : triplets) {
            System.out.println(Arrays.toString(triplet));
        }
    }

}
