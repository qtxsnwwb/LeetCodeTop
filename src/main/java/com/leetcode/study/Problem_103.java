package com.leetcode.study;

import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Problem_103 {
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
        List<List<Integer>> ans = new Solution_103().zigzagLevelOrder(root);
        for(int i=0; i<ans.size(); i++){
            List<Integer> list = ans.get(i);
            for(int j=0; j<list.size(); j++){
                System.out.print(list.get(j) + " ");
            }
            System.out.println();
        }
    }
}

/**
 * 二叉树的锯齿形层序遍历
 */
class Solution_103 {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null) return null;
        List<List<Integer>> ans = new LinkedList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        boolean isOrderLeft = true;      //是否从左开始遍历

        while(!queue.isEmpty()){
            Deque<Integer> levelList = new LinkedList<>();
            int size = queue.size();
            for(int i=0; i<size; i++){
                TreeNode cur = queue.poll();
                if(isOrderLeft){
                    levelList.offerLast(cur.val);
                }else{
                    levelList.offerFirst(cur.val);
                }
                if(cur.left != null){
                    queue.offer(cur.left);
                }
                if(cur.right != null){
                    queue.offer(cur.right);
                }
            }
            ans.add(new LinkedList<>(levelList));
            isOrderLeft = !isOrderLeft;
        }
        return ans;
    }
}