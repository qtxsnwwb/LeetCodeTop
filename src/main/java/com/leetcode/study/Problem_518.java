package com.leetcode.study;

import java.util.ArrayList;
import java.util.List;

public class Problem_518 {
    public static void main(String[] args) {
        int amount = 5;
        int[] coins = {1,2,5};
        System.out.println(new Solution_518().change(amount, coins));
    }
}

/**
 * 零钱兑换2
 *
 * 动态规划
 *      dp[x] 表示金额之和等于 x 的组合数
 *      dp[i] = dp[i] + dp[i-coin]
 */
class Solution_518 {

    public int change(int amount, int[] coins) {
        int[] dp = new int[amount + 1];
        dp[0] = 1;
        for(int coin : coins){
            for(int i=coin; i<=amount; i++){
                dp[i] += dp[i-coin];
            }
        }
        return dp[amount];
    }
}
