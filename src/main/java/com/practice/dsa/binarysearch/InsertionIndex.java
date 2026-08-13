package main.java.com.practice.dsa.binarysearch;

public class InsertionIndex {

    public static int insertionIndex(int [] array, int target) {
        int low = 0;
        int high = array.length - 1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (array[mid] == target) {
                return mid;
            }  else if (array[mid] < target) {
                low = mid + 1;
            }  else {
                high = mid - 1;
            }
        }
        return low;
    }

    public static void main(String [] args){
        int[] array = {1,2,4,5,7,8,9};
        int target = 6;
        System.out.println(insertionIndex(array,target));
    }
}
