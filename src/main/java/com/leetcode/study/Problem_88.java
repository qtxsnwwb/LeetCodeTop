package com.leetcode.study;

public class Problem_88 {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,0,0,0};
        int m = 3;
        int[] nums2 = {2,5,6};
        int n = 3;
        new Solution_88().merge(nums1, m, nums2, n);
        for(int i=0; i<nums1.length; i++){
            System.out.print(nums1[i] + " ");
        }
    }
}

/**
 * 合并两个有序数组
 */
class Solution_88 {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] ans = new int[nums1.length];
        int index = 0;
        int l1 = 0, l2 = 0;
        while(l1 != m && l2 != n){
            ans[index++] = nums1[l1] < nums2[l2] ? nums1[l1++] : nums2[l2++];
        }
        if(l1 != m) System.arraycopy(nums1, l1, ans, index, m-l1);
        if(l2 != m) System.arraycopy(nums2, l2, ans, index, n-l2);
        System.arraycopy(ans, 0, nums1, 0, ans.length);
    }
}














