package com.leetcode.study;

public class Problem_70 {
    public static void main(String[] args) {
        int n = 3;
        System.out.println(new Solution_70().climbStairs(n));
    }
}

/**
 * 爬楼梯
 *
 * 动态规划
 *      爬 1 层到当前楼层与爬 2 层到达的总和  dp[i] = dp[i-1] + dp[i-2]
 */
class Solution_70 {
    public int climbStairs(int n) {
        if(n == 1) return 1;
        if(n == 2) return 2;
        int[] dp = new int[n+1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i=3; i<n+1; i++){
            dp[i] = dp[i-1] + dp[i-2];
        }
        return dp[n];
    }
}
