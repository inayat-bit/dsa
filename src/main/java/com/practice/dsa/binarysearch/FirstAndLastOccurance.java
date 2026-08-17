package main.java.com.practice.dsa.binarysearch;

import java.util.ArrayList;
import java.util.List;

public class FirstAndLastOccurance {
    public static List<Integer> firstAndLastOccurance(int[] arr, int target) {
        List<Integer> result = new ArrayList<>();
        result.add(firstOccurance(arr, target));
        result.add(lastOccurance(arr, target));
        return result;
    }

    private static int firstOccurance(int[] arr, int target) {
       int left = 0, answer = -1;
       int right = arr.length -1;
       while (left <= right) {
           int mid = left + (right - left) / 2;
           if(arr[mid] == target) {
               answer = mid;
               right = mid - 1;
           } else if (arr[mid] < target) {
               left = mid + 1;
           } else {
               right = mid - 1;
           }
       }
           return answer;
    }

    private static int lastOccurance(int[] arr, int target) {
        int left = 0, answer = -1;
        int right = arr.length -1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if(arr[mid] == target) {
                answer = mid;
                left = mid + 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return answer;

    }

    public static void main(String[] args) {

        int[] arr = {1, 2, 2, 2, 3, 4};
        int target = 2;
        System.out.println(firstAndLastOccurance(arr, target));

    }

}
