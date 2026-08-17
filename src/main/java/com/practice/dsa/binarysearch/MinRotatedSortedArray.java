package main.java.com.practice.dsa.binarysearch;

public class MinRotatedSortedArray {

    public static int findMin(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if(arr[mid] <= arr[right]) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return arr[left];
    }

    public static void main(String[] args) {
        int[] a1 = {3, 4, 5, 1, 2};
        int i1 = findMin(a1);
        System.out.println("a1 expected=1, actualValue=" + i1);

        int[] a2 = {4, 5, 6, 7, 0, 1, 2};
        int i2 = findMin(a2);
        System.out.println("a2 expected=0, actualValue=" + i2);

    }
}
