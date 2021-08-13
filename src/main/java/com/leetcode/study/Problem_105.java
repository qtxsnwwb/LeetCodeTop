package com.leetcode.study;

import java.util.Arrays;

public class Problem_105 {
    public static void main(String[] args) {
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        TreeNode ans = new Solution_105().buildTree(preorder, inorder);
        System.out.println(ans.val + " " + ans.left.val + " " + ans.right.val + " " + ans.right.left.val
                            + " " + ans.right.right.val);
    }
}

/**
 * 从前序与中序遍历序列构造二叉树
 */
class Solution_105 {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0 || inorder.length == 0) return null;
        TreeNode root = new TreeNode(preorder[0]);
        int i;
        for(i=0; i<inorder.length; i++){
            if(inorder[i] == preorder[0]) break;
        }
        root.left = buildTree(Arrays.copyOfRange(preorder, 1, i+1),
                Arrays.copyOfRange(inorder, 0, i));
        root.right = buildTree(Arrays.copyOfRange(preorder, i+1, preorder.length),
                Arrays.copyOfRange(inorder, i+1, inorder.length));
        return root;
    }
}














