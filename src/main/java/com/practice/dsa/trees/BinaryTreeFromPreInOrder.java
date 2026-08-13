package main.java.com.practice.dsa.trees;

import java.util.HashMap;

public class BinaryTreeFromPreInOrder {
    static HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
    static int index = 0;
    static TreeNode binaryTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);

        }
        return binaryTreeUtil(preorder, 0, inorder.length - 1);

    }

    static TreeNode binaryTreeUtil(int[] preorder, int left, int right) {
        if (left > right) {return null;}
        int rootVal = preorder[index++];
        TreeNode root = new TreeNode(rootVal);
        int indexIn = map.get(rootVal);
        root.left = binaryTreeUtil(preorder, left, indexIn - 1);
        root.right = binaryTreeUtil(preorder, indexIn + 1, right);
        return root;


    }

    public static void main(String[] args) {
        int[] preorder = {1,2,3,4,5,6,7,8};
        int[] inorder = {1,2,3,4,5,6,7,8};
        TreeNode root = binaryTree(preorder, inorder);
        TreeNode.printInorder(root);
    }
}
