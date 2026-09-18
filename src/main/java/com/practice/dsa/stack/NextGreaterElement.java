package main.java.com.practice.dsa.stack;

import java.util.Arrays;
import java.util.Stack;

public class NextGreaterElement {
    public static int[] next(int[] arr) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[arr.length];
        Arrays.fill(result, -1);
        for (int i= 0; i < arr.length; i++) {
            while(!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                result[stack.peek()] = arr[i];
                stack.pop();
            }
            stack.push(i);
        }
        return result;

    }

    public static void main(String[] args) {
        int[] arr = {4, 5, 2, 25, 7, 8};
        int[] ans = next(arr);

        System.out.println("Input : " + Arrays.toString(arr));
        System.out.println("Next  : " + Arrays.toString(ans));
        // Expected: [5, 25, 25, -1, 8, -1]
    }
}
