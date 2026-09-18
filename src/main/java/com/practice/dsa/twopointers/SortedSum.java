package main.java.com.practice.dsa.twopointers;

import java.util.Arrays;

public class SortedSum {
    public static int[] sortedSum(int[] arr, int sum) {
        int left = 0;
        int right = arr.length - 1;
        int[] result = new int[2];
        while (left < right) {
            if (arr[left] + arr[right] == sum) {
                result[0] = left;
                result[1] = right;
                return result;
            } else if(arr[left] + arr[right] < sum) {
                left ++;
            } else {
                right --;
            }
        }
        return result;

    }

    public static void main(String[] args) {
        int[] arr = {1, 2, 4, 7, 11, 15};
        int target = 15;

        int[] res = sortedSum(arr, target);
        System.out.println("Indexes: " + Arrays.toString(res));

        if (res[0] != -1) {
            System.out.println("Values: " + arr[res[0]] + " + " + arr[res[1]] + " = " + target);
        }
    }
}
