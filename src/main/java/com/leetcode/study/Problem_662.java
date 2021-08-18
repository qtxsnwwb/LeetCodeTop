package com.leetcode.study;

import java.util.HashMap;
import java.util.Map;

public class Problem_662 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(3);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(5);
        TreeNode node4 = new TreeNode(3);
        TreeNode node5 = new TreeNode(9);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.right = node5;
        System.out.println(new Solution_662().widthOfBinaryTree(root));
    }
}

/**
 * 二叉树最大宽度
 *
 *  深度优先遍历
 *      记录每个节点的 position。对于每一个深度，第一个到达的位置会被记录在 left[depth] 中。
 *      然后对于每一个节点，它对应这一层的可能宽度是 pos - left[depth] + 1 。我们将每一层这些可能的宽度取一个最大值就是答案
 */
class Solution_662 {
    int ans;
    Map<Integer, Integer> left;

    public int widthOfBinaryTree(TreeNode root) {
        ans = 0;
        left = new HashMap<>();
        dfs(root, 0, 0);
        return ans;
    }

    private void dfs(TreeNode root, int depth, int pos) {
        if(root == null) return;
        left.computeIfAbsent(depth, x->pos);
        ans = Math.max(ans, pos-left.get(depth)+1);
        dfs(root.left, depth+1, 2* pos);
        dfs(root.right, depth+1, 2*pos+1);
    }
}
