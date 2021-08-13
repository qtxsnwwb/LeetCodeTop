package com.leetcode.study;

import java.util.ArrayList;
import java.util.List;

public class Problem_114 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(5);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(6);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.right = node5;
        new Solution_114().flatten(root);
        while(root != null){
            System.out.print(root.val + " ");
            root = root.right;
        }
    }
}

/**
 * 二叉树展开为链表
 */
class Solution_114 {
    public void flatten(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        preorder(root, list);
        for(int i=1; i<list.size(); i++){
            TreeNode prev = list.get(i-1), curr = list.get(i);
            prev.left = null;
            prev.right = curr;
        }
    }

    private void preorder(TreeNode node, List<TreeNode> list) {
        if(node != null){
            list.add(node);
            preorder(node.left, list);
            preorder(node.right, list);
        }
    }
}