package main.java.com.practice.dsa.slidingwindow;

public class MaximumConsecutive1 {
    private static int maximumConsecutive1(int[] nums, int k) {
        int left = 0;
        int right = 0;
        int max = 0;
        int flip = 0;
        while (right < nums.length) {
            while(nums[right] == 0 && flip == k) {
                if(nums[left] == 0) {
                    flip--;
                    left++;
                } else {
                    left++;
                }
            }
            if(nums[right] == 0 && flip < k) flip++;
            right++;
            max = Math.max(max, right - left);
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = {1, 0, 0, 0, 1, 1};
        int k = 2;
        System.out.println(maximumConsecutive1(nums, k));
    }
}
