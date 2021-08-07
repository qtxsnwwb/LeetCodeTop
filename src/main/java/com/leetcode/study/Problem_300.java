package com.leetcode.study;

public class Problem_300 {
    public static void main(String[] args) {
        int[] nums = {10,9,2,5,3,7,101,18};
        System.out.println(new Solution_300().lengthOfLIS(nums));
    }
}

/**
 * 最长递增子序列
 *
 * 解题：
 *      动态规划
 *      dp[i]表示前 i 个元素最长递增子序列
 *      dp[i] = max(dp[j]) + 1
 */
class Solution_300 {
    public int lengthOfLIS(int[] nums) {
        if(nums.length == 0) return 0;
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxans = 1;
        for(int i=1; i<nums.length; i++){
            dp[i] = 1;
            for(int j=0; j<i; j++){
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
            maxans = Math.max(maxans, dp[i]);
        }
        return maxans;
    }
}


















