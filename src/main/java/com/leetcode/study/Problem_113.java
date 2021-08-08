package com.leetcode.study;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class Problem_113 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode node1 = new TreeNode(4);
        TreeNode node2 = new TreeNode(8);
        TreeNode node3 = new TreeNode(11);
        TreeNode node4 = new TreeNode(13);
        TreeNode node5 = new TreeNode(4);
        TreeNode node6 = new TreeNode(7);
        TreeNode node7 = new TreeNode(2);
        TreeNode node8 = new TreeNode(5);
        TreeNode node9 = new TreeNode(1);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        node3.right = node7;
        node5.left = node8;
        node5.right = node9;
        int targetSum = 22;
        List<List<Integer>> ans = new Solution_113().pathSum(root, targetSum);
        for(List<Integer> list : ans) {
            for(Integer num : list) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}

/**
 * 路径总和 2
 *
 * 深度优先遍历
 *      类似 39 组和总和问题
 */
class Solution_113 {
    List<List<Integer>> ret = new LinkedList<>();
    Deque<Integer> path = new LinkedList<>();
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        dfs(root, targetSum);
        return ret;
    }

    public void dfs(TreeNode root, int targetSum) {
        if(root == null) return;
        path.offerLast(root.val);
        targetSum -= root.val;
        if(root.left == null && root.right == null && targetSum == 0) {
            ret.add(new LinkedList<>(path));
        }
        dfs(root.left, targetSum);
        dfs(root.right, targetSum);
        path.pollLast();
    }
}
