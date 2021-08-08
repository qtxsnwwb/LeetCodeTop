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

    int maxSum = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxGain(root);
        return maxSum;
    }

    public int maxGain(TreeNode node){
        if(node == null) return 0;

        //递归计算左右子节点的最大贡献值
        //只有在最大贡献值大于 0 时，才会选取对应子节点
        int leftGain = Math.max(maxGain(node.left), 0);
        int rightGain = Math.max(maxGain(node.right), 0);

        //节点的最大路径和取决于该节点的值与该节点的左右子节点的最大贡献值
        int priceNewpath = node.val + leftGain + rightGain;

        //更新答案
        maxSum = Math.max(maxSum, priceNewpath);

        //返回节点的最大贡献值
        return node.val + Math.max(leftGain, rightGain);
    }
}









