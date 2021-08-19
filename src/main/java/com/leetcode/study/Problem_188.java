package com.leetcode.study;

import java.util.Arrays;

public class Problem_188 {
    public static void main(String[] args) {
        int k = 2;
        int[] prices = {2,4,1};
        System.out.println(new Solution_188().maxProfit(k, prices));
    }
}

/**
 * 买卖股票的最佳时机 4
 *
 *  动态规划
 *      buy[i][j]：进行恰好 j 笔交易，并且当前手上持有一支股票，这种情况下的最大利润
 *      sell[i][j]：恰好进行 j笔交易，并且当前手上不持有股票，这种情况下的最大利润
 *      对于 buy[i][j]
 *          若当前手上的股票是在第 i 天买入的，那么 i-1 天手上不持有股票
 *              对应状态 sell[i-1][j] - prices[i]
 *          若当前手上的股票不是在第 i天买入的，那么 i-1 天手上持有股票
 *              对应状态 buy[i-1][j]
 *          则
 *              buy[i][j] = max{buy[i-1][j], sell[i-1][j]-prices[i]}
 *       同理 sell[i][j]
 *          则
 *              sell[i][j] = max{sell[i-1][j], buy[i-1][j-1]+prices[i]}
 *       最终答案即为 sell[n-1][0...k] 中的最大值
 */
class Solution_188 {
    public int maxProfit(int k, int[] prices) {
        if(prices.length == 0) return 0;
        int n = prices.length;
        k = Math.min(k, n / 2);
        int[][] buy = new int[n][k + 1];
        int[][] sell = new int[n][k + 1];

        buy[0][0] = -prices[0];
        sell[0][0] = 0;
        for(int i=1; i<=k; i++)
            buy[0][i] = sell[0][i] = Integer.MIN_VALUE / 2;

        for(int i=1; i<n; i++){
            buy[i][0] = Math.max(buy[i - 1][0], sell[i - 1][0] - prices[i]);
            for (int j = 1; j <= k; ++j) {
                buy[i][j] = Math.max(buy[i - 1][j], sell[i - 1][j] - prices[i]);
                sell[i][j] = Math.max(sell[i - 1][j], buy[i - 1][j - 1] + prices[i]);
            }
        }
        return Arrays.stream(sell[n-1]).max().getAsInt();
    }
}
