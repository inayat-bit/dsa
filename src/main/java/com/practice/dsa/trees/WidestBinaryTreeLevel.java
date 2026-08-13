package main.java.com.practice.dsa.trees;

import java.util.LinkedList;
import java.util.Queue;

class Pair<K, V> {
    K key;
    V value;
    public Pair(K key, V value) {
        this.key = key;
        this.value = value;
    }

}

public class WidestBinaryTreeLevel {

    static int widestBinaryTreeLevel(TreeNode root) {
        int result = 0;
        Queue<Pair<TreeNode, Integer>> queue = new LinkedList<>();
        queue.offer(new Pair<>(root, 0));
        while(!queue.isEmpty()) {
            int leftIndex = queue.peek().value;
            int rightIndex = leftIndex;
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                Pair<TreeNode, Integer> pair = queue.poll();
                TreeNode node = pair.key;
                int index = pair.value;
                if(node.left != null) {
                    queue.offer(new Pair<>(node.left, 2*index + 1));
                }
                if(node.right != null) {
                    queue.offer(new Pair<>(node.right, 2*index + 2));
                }
                rightIndex = index;
            }
            result = Math.max(result, rightIndex - leftIndex + 1);

        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        //root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);
        root.left.left.left = new TreeNode(8);
        root.left.left.right = new TreeNode(9);
        root.left.right.right = new TreeNode(11);
        root.right.right.left = new TreeNode(14);
        System.out.println(WidestBinaryTreeLevel.widestBinaryTreeLevel(root));
    }
}
