package com.leetcode.study;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Problem_236 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(5);
        TreeNode node2 = new TreeNode(1);
        TreeNode node3 = new TreeNode(6);
        TreeNode node4 = new TreeNode(2);
        TreeNode node5 = new TreeNode(0);
        TreeNode node6 = new TreeNode(8);
        TreeNode node7 = new TreeNode(7);
        TreeNode node8 = new TreeNode(4);
        root.left = node1;
        root.right = node2;
        node1.left = node3;
        node1.right = node4;
        node2.left = node5;
        node2.right = node6;
        node4.left = node7;
        node4.right = node8;
        TreeNode ans = new Solution_236().lowestCommonAncestor(root, node1, node8);
        System.out.println(ans.val);
    }
}

/**
 * 二叉树的最近公共祖先
 *
 * 解题：
 *      用哈希表存储所有节点的父节点，利用节点的父节点从 p 开始不断向上遍历，并记录已经访问过的节点，
 *      再从 q开始不断往上跳，如果碰到已经访问过的节点，那这个节点就是要找的最近公共祖先
 */
class Solution_236 {

    Map<Integer, TreeNode> parent = new HashMap<>();
    Set<Integer> visited = new HashSet<>();

    public void dfs(TreeNode root) {
        if(root.left != null) {
            parent.put(root.left.val, root);
            dfs(root.left);
        }
        if(root.right != null) {
            parent.put(root.right.val, root);
            dfs(root.right);
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root);
        while(p != null) {
            visited.add(p.val);
            p = parent.get(p.val);
        }
        while(q != null) {
            if(visited.contains(q.val)) {
                return q;
            }
            q = parent.get(q.val);
        }
        return null;
    }
}
