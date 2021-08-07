package com.leetcode.study;

public class Problem_124 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(-10);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(7);
        root.left = node1;
        root.right = node2;
        node2.left = node3;
        node2.right = node4;
        System.out.println(new Solution_124().maxPathSum(root));
    }
}

/**
 * 二叉树中的最大路径和
 */
class Solution_124 {
    public int maxPathSum(TreeNode root) {

    }
}









