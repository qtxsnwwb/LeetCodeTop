package com.leetcode.study;

import java.util.ArrayList;
import java.util.List;

public class Problem_145 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        root.right = node1;
        node1.left = node2;
        List<Integer> ans = new Solution_145().postorderTraversal(root);
        for(Integer num : ans){
            System.out.print(num + " ");
        }
    }
}

/**
 * 二叉树的后序遍历
 */
class Solution_145 {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        postorder(root, ans);
        return ans;
    }

    private void postorder(TreeNode root, List<Integer> ans) {
        if(root != null){
            postorder(root.left, ans);
            postorder(root.right, ans);
            ans.add(root.val);
        }
    }
}
