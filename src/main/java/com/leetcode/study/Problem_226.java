package com.leetcode.study;

public class Problem_226 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(7);
        TreeNode node3 = new TreeNode(1);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(6);
        TreeNode node6 = new TreeNode(9);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;
        TreeNode ans = new Solution_226().invertTree(root);
        System.out.print(ans.val + " ");
        System.out.print(ans.left.val + " ");
        System.out.print(ans.right.val + " ");
        System.out.print(ans.left.left.val + " ");
        System.out.print(ans.left.right.val + " ");
        System.out.print(ans.right.left.val + " ");
        System.out.print(ans.right.right.val + " ");
    }
}

/**
 * 翻转二叉树
 */
class Solution_226 {
    public TreeNode invertTree(TreeNode root) {
        if(root != null){
            TreeNode node = root.right;
            root.right = root.left;
            root.left = node;
            invertTree(root.left);
            invertTree(root.right);
        }
        return root;
    }
}
