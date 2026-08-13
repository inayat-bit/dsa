package main.java.com.practice.dsa.slidingwindow;

public class MinimumSubArraySum {
    private static int minimumSubArraySum(int[] nums, int sum) {
        int left = 0;
        int right = 0;
        int target = 0;
        int min = Integer.MAX_VALUE;
        while (right < nums.length) {
            target += nums[right];
            while (target >= sum) {
                min = Math.min(min, right - left +1);
                target = target - nums[left];
                left ++;
            }

            right++;
        }
        return min == Integer.MAX_VALUE ? 0 : min;
    }

    public static void main(String[] args) {
        int[] nums = new int[] {8};
        System.out.println(minimumSubArraySum(nums, 7));
    }
}
