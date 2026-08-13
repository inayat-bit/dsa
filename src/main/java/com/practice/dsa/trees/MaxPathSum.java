package main.java.com.practice.dsa.trees;

public class MaxPathSum {
    static int maxSum = Integer.MIN_VALUE;

    static int maxPathSum(TreeNode root) {
        maxPathSumUtil(root);
        return maxSum;
    }
    static int maxPathSumUtil(TreeNode root) {
        if(root == null) return 0;
        int left = maxPathSumUtil(root.left);
        int right = maxPathSumUtil(root.right);
        int currentMax = left + right + root.val;
        maxSum = Math.max(maxSum, currentMax);
        return root.val + Math.max(left, right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(-10);

        root.left = new TreeNode(9);

        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        System.out.println(maxPathSum(root));
    }
}
