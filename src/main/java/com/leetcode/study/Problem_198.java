package com.leetcode.study;

public class Problem_198 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        System.out.println(new Solution_198().rob(nums));
    }
}

/**
 * 打家劫舍
 *
 * 动态规划
 *      dp[i]：是否偷窃当前房屋能获得的最大金额
 *      若偷窃当前房屋 dp[i] = dp[i-2] + nums[i]
 *      若不偷窃当前房屋 dp[i] = dp[i-1]
 *      则 dp[i] = max{dp[i-2] + nums[i], dp[i-1]}
 */
class Solution_198 {
    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];
        if(nums.length == 2) return nums[0] > nums[1] ? nums[0] : nums[1];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = nums[0] > nums[1] ? nums[0] : nums[1];
        for(int i=2; i<nums.length; i++){
            dp[i] = Math.max(dp[i-2] + nums[i], dp[i-1]);
        }
        return dp[dp.length-1];
    }
}
