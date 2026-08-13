package main.java.com.practice.dsa.trees;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class RightMostBinaryTree {
    static List<Integer> rightMostBinaryTree(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        List<Integer> result = new LinkedList<>();
        if (root == null) return result;
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
                if(i ==  size - 1) result.add(node.val);
            }

        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        System.out.println(rightMostBinaryTree(root));
    }
}
