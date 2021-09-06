package com.leetcode.study;

import java.util.ArrayList;
import java.util.List;

public class Problem_144 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode node1 = new TreeNode(2);
        TreeNode node2 = new TreeNode(3);
        root.right = node1;
        node1.left = node2;
        List<Integer> ans = new Solution_144().preorderTraversal(root);
        for(Integer num : ans){
            System.out.print(num + " ");
        }
    }
}

class Solution_144 {
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        if(root == null) return list;
        preorder(root, list);
        return list;
    }
    private void preorder(TreeNode root, List<Integer> list){
        if(root != null){
            list.add(root.val);
            preorder(root.left, list);
            preorder(root.right, list);
        }
    }
}