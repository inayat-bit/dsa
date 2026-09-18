package main.java.com.practice.dsa.stack;

import java.util.Arrays;
import java.util.Stack;

public class DailyTemperature {
    public static int[] dailyTemperature(int[] temperature) {
        Stack<Integer> stack = new Stack<>();
        int[] result = new int[temperature.length];
        for(int i = 0; i < temperature.length; i++) {
            while(!stack.isEmpty() && temperature[i] > temperature[stack.peek()]) {
                int previousIndex = stack.pop();
                result[previousIndex] = i - previousIndex;
            }
            stack.push(i);
        }
        return result;

    }

    public static void main(String[] args) {
        int[] temperatures = {73, 74, 75, 71, 69, 72, 76, 73};
        int[] answer = dailyTemperature(temperatures);

        System.out.println("Input : " + Arrays.toString(temperatures));
        System.out.println("Output: " + Arrays.toString(answer));
        // Expected: [1, 1, 4, 2, 1, 1, 0, 0]
    }
}
