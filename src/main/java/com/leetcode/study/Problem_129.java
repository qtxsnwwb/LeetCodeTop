package com.leetcode.study;

public class Problem_129 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(4);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(0);
        TreeNode node3 = new TreeNode(5);
        TreeNode node4 = new TreeNode(1);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        System.out.println(new Solution_129().sumNumbers(root));
    }
}

/**
 * 求根节点到叶节点数字之和
 */
class Solution_129 {
    public int sumNumbers(TreeNode root) {
        return dfs(root, 0);
    }

    private int dfs(TreeNode root, int prevSum) {
        if(root == null) return 0;
        int sum = prevSum * 10 + root.val;
        if(root.left == null && root.right == null){
            return sum;
        }else{
            return dfs(root.left, sum) + dfs(root.right, sum);
        }
    }
}
