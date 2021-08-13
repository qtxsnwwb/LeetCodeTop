package com.leetcode.study;

import java.util.ArrayList;
import java.util.List;

public class Problem_94 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        root.right = node1;
        node1.left = node2;
        List<Integer> ans = new Solution_94().inorderTraversal(root);
        for(Integer num : ans){
            System.out.print(num + " ");
        }
    }
}

/**
 * 二叉树的中序遍历
 */
class Solution_94 {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        inorder(root, ans);
        return ans;
    }

    private void inorder(TreeNode root, List<Integer> ans) {
        if(root == null) return;
        inorder(root.left, ans);
        ans.add(root.val);
        inorder(root.right, ans);

    }
}
