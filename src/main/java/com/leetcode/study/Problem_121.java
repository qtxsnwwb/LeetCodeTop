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
 * 解题：
 *      考虑在历史最低点买进股票，第i天得到的利润为prices[i] - minPrice
 *      因此只需要遍历价格数组一遍，记录历史最低点，考虑在历史最低点买进，那么今天卖出能赚多少钱
 */
class Solution_121 {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for(int i=0; i<prices.length; i++){
            if(prices[i] < minPrice){
                minPrice = prices[i];
            }else if(prices[i] - minPrice > maxProfit){
                maxProfit = prices[i] - minPrice;
            }
        }
        return maxProfit;
    }
}

















