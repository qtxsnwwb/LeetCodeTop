package com.leetcode.study;

import java.util.LinkedList;
import java.util.Queue;

public class Problem_104 {
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
        System.out.println(new Solution_104().maxDepth(root));
    }
}

/**
 * 二叉树的最大深度
 */
class Solution_104 {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int ans = 0;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i=0; i<size; i++){
                TreeNode top = queue.poll();
                if(top.left != null) queue.offer(top.left);
                if(top.right != null) queue.offer(top.right);
            }
            ans++;
        }
        return ans;
    }
}
























