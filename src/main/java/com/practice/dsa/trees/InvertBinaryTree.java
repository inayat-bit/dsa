package main.java.com.practice.dsa.trees;


public class InvertBinaryTree {
    static void invertBinaryTree(TreeNode root) {
        if (root == null) {
            return;
        }

        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        invertBinaryTree(root.left);
        invertBinaryTree(root.right);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(1);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(7);
        root.left.right = new TreeNode(6);
        root.right.right = new TreeNode(4);
        System.out.print("Before: ");
        TreeNode.printInorder(root);
        System.out.println();

        invertBinaryTree(root);

        System.out.print("After: ");
        TreeNode.printInorder(root);
        System.out.println();

    }
}
