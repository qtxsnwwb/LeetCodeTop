package com.leetcode.study;

public class Problem_108 {
    public static void main(String[] args) {
        int[] nums = {-10,-3,0,5,9};
        TreeNode ans = new Solution_108().sortedArrayToBST(nums);
        System.out.print(ans.val + " ");
        System.out.print(ans.left.val + " ");
        System.out.print(ans.right.val + " ");
        System.out.print(ans.left.left.val + " ");
        System.out.print(ans.right.left.val + " ");
    }
}

/**
 * 将有序数组转换为二叉搜索树
 *
 *      总是选择中间位置左边的数字作为根节点
 */
class Solution_108 {
    public TreeNode sortedArrayToBST(int[] nums) {
        return helper(nums, 0, nums.length - 1);
    }

    private TreeNode helper(int[] nums, int left, int right) {
        if(left > right) return null;

        int mid = (left + right) / 2;

        TreeNode root = new TreeNode(nums[mid]);
        root.left = helper(nums, left, mid - 1);
        root.right = helper(nums, mid + 1, right);
        return root;
    }
}
