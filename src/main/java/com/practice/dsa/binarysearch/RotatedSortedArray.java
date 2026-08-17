package main.java.com.practice.dsa.binarysearch;

public class RotatedSortedArray {
    public static int findElement(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if(arr[mid] == target) {
                return mid;
            } else if (arr[mid] >= arr[left]) {
                if(arr[left] <= target && arr[mid] > target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            } else {
                if(arr[right] >= target && arr[mid] < target) {
                    left = mid + 1;
                } else {
                    right = mid -1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(findElement(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));   // rotated, found
        System.out.println(findElement(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));  // rotated, not found
    }
}
