package com.leetcode.study;

import java.util.*;

public class Problem_230 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(4);
        TreeNode node3 = new TreeNode(2);
        root.left = node1;
        root.right = node2;
        node1.right = node3;
        int k = 1;
        System.out.println(new Solution_230().kthSmallest(root, k));
    }
}

/**
 * 二叉搜索树中第K小的元素
 */
class Solution_230 {
    public int kthSmallest(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode top = queue.poll();
            list.add(top.val);
            if(top.left != null) queue.offer(top.left);
            if(top.right != null) queue.offer(top.right);
        }
        int[] array = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            array[i] = list.get(i);
        }
        Arrays.sort(array);
        return array[k-1];
    }
}
