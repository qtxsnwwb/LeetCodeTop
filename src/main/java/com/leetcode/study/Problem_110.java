package com.leetcode.study;

public class Problem_110 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(7);
        root.left = node1;
        root.right = node2;
        node2.left = node3;
        node2.right = node4;
        System.out.println(new Solution_110().isBalanced(root));
    }
}

/**
 * 平衡二叉树
 */
class Solution_110 {
    public boolean isBalanced(TreeNode root) {
        if(root == null) return true;
        return Math.abs(depth(root.left) - depth(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    private int depth(TreeNode node) {
        if(node == null) return 0;
        int L = depth(node.left);
        int R = depth(node.right);
        return Math.max(L, R) + 1;
    }
}
