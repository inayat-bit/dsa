package main.java.com.practice.dsa.twopointers;

public class ContainerWithMostWater {
    public static int maxArea(int[] height) {
        int left = 0, right = height.length - 1;
        int maxArea = 0;
        while (left < right) {
            int width = right - left;
            int area = (Math.min(height[right], height[left])) * width;
            maxArea = Math.max(maxArea, area);
            if(height[left] < height[right]) left++;
            else right--;
        }
        return maxArea;
    }

    public static void main(String[] args) {
        // Test case 1: [1,8,6,2,5,4,8,3,7]
        int[] test1 = {1, 8, 6, 2, 5, 4, 8, 3, 7};
        System.out.println("Test 1: " + maxArea(test1) + " (expected: 49)");

        // Test case 2: [1, 1]
        int[] test2 = {1, 1};
        System.out.println("Test 2: " + maxArea(test2) + " (expected: 1)");

        // Test case 3: [2, 3, 4, 5, 18, 17, 6]
        int[] test3 = {2, 3, 4, 5, 18, 17, 6};
        System.out.println("Test 3: " + maxArea(test3) + " (expected: 17)");
    }
}
