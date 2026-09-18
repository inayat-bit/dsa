package main.java.com.practice.dsa.arraysandhashing;

import java.util.Arrays;

public class ProductOfArray {
    public static int[] product(int[] arr) {
        if(arr.length == 0) return new int[0];
        int[] suffix = new int[arr.length];
        int[] result = new int[arr.length];
        suffix[0] = 1;
        for (int i = 1; i < arr.length; i++) {
            suffix[i] = arr[i-1]*suffix[i-1];
        }
        int prefix = 1;
        for (int i = arr.length-1; i >= 0; i--) {
            result[i] = prefix * suffix[i];
            prefix = prefix * arr[i];
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(product(new int[]{1, 2, 3, 4}))); // [24, 12, 8, 6]
        System.out.println(Arrays.toString(product(new int[]{-1, 1, 0, -3, 3}))); // [0, 0, 9, 0, 0]
        System.out.println(Arrays.toString(product(new int[]{5}))); // [1]
        System.out.println(Arrays.toString(product(new int[]{}))); // []
    }
}
