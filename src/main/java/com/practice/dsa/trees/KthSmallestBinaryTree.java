package main.java.com.practice.dsa.trees;

import java.util.ArrayList;
import java.util.List;

public class KthSmallestBinaryTree {
    static int kthSmallest(TreeNode root, int k) {
        List<Integer> list = inorder(root);
        return list.get(k - 1);

    }

    static List<Integer> inorder(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if (root == null) return list;
        list.addAll(inorder(root.left));
        list.add(root.val);
        list.addAll(inorder(root.right));
        return list;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);

        root.left = new TreeNode(3);
        root.right = new TreeNode(6);

        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);

        root.left.left.left = new TreeNode(1);
        System.out.println(kthSmallest(root, 3));
    }
}
