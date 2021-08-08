package com.leetcode.study;

import java.util.LinkedList;
import java.util.Queue;

public class Problem_958 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(4);
        TreeNode node4 = new TreeNode(5);
        TreeNode node5 = new TreeNode(7);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.right = node5;
        System.out.println(new Solution_958().isCompleteTree(root));
    }
}

/**
 * 二叉树的完全性检验
 *
 * 广度优先遍历
 *      遍历过程中遇到一个空节点之后不应该再出现非空节点
 */
class Solution_958 {
    public boolean isCompleteTree(TreeNode root) {
        if(root == null) return true;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean reachEnd = false;
        while(!queue.isEmpty()){
            TreeNode cur = queue.poll();
            if(reachEnd && cur != null) return false;
            if(cur == null){
                reachEnd = true;
                continue;
            }
            queue.offer(cur.left);
            queue.offer(cur.right);
        }
        return true;
    }
}
