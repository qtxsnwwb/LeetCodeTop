package com.leetcode.study;

public class Problem_718 {
    public static void main(String[] args) {
        int[] nums1 = {1,2,3,2,1};
        int[] nums2 = {3,2,1,4,7};
        System.out.println(new Solution_718().findLength(nums1, nums2));
    }
}

/**
 * 最长重复子数组
 */
class Solution_718 {
    public int findLength(int[] nums1, int[] nums2) {
        int n = nums1.length, m = nums2.length;
        int[][] dp = new int[n+1][m+1];
        int ans = 0;
        for(int i=n-1; i>=0; i--){
            for(int j=m-1; j>=0; j--){
                dp[i][j] = nums1[i] == nums2[j] ? dp[i+1][j+1] + 1 : 0;
                ans = Math.max(ans, dp[i][j]);
            }
        }
        return ans;
    }
}
