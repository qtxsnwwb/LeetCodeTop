package com.leetcode.study;

public class Problem_122 {
    public static void main(String[] args) {
        int[] prices = {7,1,5,3,6,4};
        System.out.println(new Solution_122().maxProfit(prices));
    }
}

/**
 * 买卖股票的最佳时机2
 *
 * 动态规划
 *      dp[i][0] 表示第 i 天交易完成后手里没有股票的最大利润
 *      dp[i][1] 表示第 i 天交易完成后手里持有股票的最大利润
 *      dp[i][0] = max{dp[i-1][0], dp[i-1][1] + prices[i]}
 *      dp[i][1] = max{dp[i-1][0] - prices[i], dp[i-1][1]}
 */
class Solution_122 {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];
        dp[0][0] = 0;
        dp[0][1] = -prices[0];
        for(int i=1; i<n; i++){
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], dp[i-1][0] - prices[i]);
        }
        return dp[n-1][0];
    }
}
