package main.java.com.practice.dsa.trees;

public class BinarySearchTreeValidation {
    static boolean isBST(TreeNode root) {
        return isBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }
    static boolean isBSTUtil(TreeNode root, int min, int max) {
        if (root == null) {return true;}
        if (root.val < min || root.val > max) {return false;}
        return isBSTUtil(root.left, min, root.val) && isBSTUtil(root.right, root.val, max);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(7);
        root.right.right = new TreeNode(6);
        System.out.println(isBST(root));
    }
}
