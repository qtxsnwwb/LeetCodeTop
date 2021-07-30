package com.leetcode.study;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Problem_199 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        TreeNode node3 = new TreeNode(5);
        TreeNode node4 = new TreeNode(4);
        root.left = node1;
        root.right = node2;
        node1.right = node3;
        node2.right = node4;
        List<Integer> ans = new Solution_199().rightSideView(root);
        for(Integer node : ans){
            System.out.print(node + " ");
        }
    }
}

/**
 * 二叉树的右视图
 *
 * 广度优先遍历变式
 */
class Solution_199 {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if(root == null) return ans;
        ans.add(root.val);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty()){
            TreeNode right = null;
            int len = queue.size();
            for(int i=0; i<len; i++){
                TreeNode node = queue.poll();
                if(node.left != null){
                    queue.offer(node.left);
                    right = node.left;
                }
                if(node.right != null){
                    queue.offer(node.right);
                    right = node.right;
                }
            }
            if(right != null){
                ans.add(right.val);
            }
        }
        return ans;
    }
}
