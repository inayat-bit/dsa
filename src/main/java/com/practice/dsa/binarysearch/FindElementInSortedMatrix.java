package main.java.com.practice.dsa.binarysearch;

public class FindElementInSortedMatrix {
    public static boolean searchMatrix(int[][] mat, int target) {
        int rows = mat.length;
        int cols = mat[0].length;
        int left = 0;
        int right = rows * cols - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            int row = mid / cols;
            int col = mid % cols;
            if(mat[row][col] == target) {
                return true;
            } else if (mat[row][col] > target) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {

        int[][] matrix = {
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12}
        };

        int target = 10;

        boolean result = searchMatrix(matrix, target);

        System.out.println("Target " + target + " found: " + result);
    }
}
