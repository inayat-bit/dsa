package main.java.com.practice.dsa.trees;

public class LCABinaryTree {

    static TreeNode lcaBinaryTree(TreeNode root, int p, int q) {
        if (root == null) {return null;}
        if(root.val == p || root.val == q){
            return root;
        }
        TreeNode left = lcaBinaryTree(root.left, p, q);
        TreeNode right = lcaBinaryTree(root.right, p, q);
        if(left != null && right != null) return root;
        return right == null ? left : right;

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);

        root.left = new TreeNode(5);
        root.right = new TreeNode(1);

        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(2);

        root.right.left = new TreeNode(0);
        root.right.right = new TreeNode(8);

        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(4);
        System.out.println(lcaBinaryTree(root, 5, 1).val);
    }
}
