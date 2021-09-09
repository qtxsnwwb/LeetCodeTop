package com.leetcode.study;

public class Problem_121 {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(new Solution_121().maxProfit(prices));
    }
}

/**
 * 买卖股票的最佳时机
 *
 * 动态规划
 * 解题：
 *      dp[i][0]：第 i 天不持股手上的现金数
 *          * 昨天不持股，今天啥也不干
 *          * 昨天持股，今天卖出
 *          * dp[i][0] = max{dp[i-1][0], dp[i][1] + prices[i]}
 *      dp[i][1]：第 i 天持股手上的现金数
 *          * 昨天持股，今天啥也不干
 *          * 昨天不持股，今天买入
 *          * dp[i][1] = max{dp[i-1][1], -prices[i]}
 */
class Solution_121 {
    public int maxProfit(int[] prices) {
        int len = prices.length;
        if(len < 2) return 0;
        int[][] dp = new int[len][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for(int i=1; i<len; i++){
            dp[i][0] = Math.max(dp[i-1][0], dp[i][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], -prices[i]);
        }
        return dp[len-1][0];
    }
}

















