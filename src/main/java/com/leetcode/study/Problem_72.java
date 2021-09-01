package com.leetcode.study;

public class Problem_72 {
    public static void main(String[] args) {
        String word1 = "horse";
        String word2 = "ros";
        System.out.println(new Solution_72().minDistance(word1, word2));
    }
}

/**
 * 编辑距离
 *
 *  动态规划
 *      word1[i] == word2[j]，dp[i][j] = dp[i-1][j-1]
 *      word1[i] != word2[j]，dp[i][j] = min{dp[i-1][j-1], dp[i-1][j], dp[i][j-1]} + 1
 *          dp[i-1][j-1]：替换操作
 *          dp[i-1][j]：删除操作
 *          dp[i][j-1]：插入操作
 */
class Solution_72 {
    public int minDistance(String word1, String word2) {
        int n1 = word1.length();
        int n2 = word2.length();
        int[][] dp = new int[n1 + 1][n2 + 1];
        //第一行
        for(int j=1; j<=n2; j++) dp[0][j] = dp[0][j-1] + 1;
        //第一列
        for(int i=1; i<=n1; i++) dp[i][0] = dp[i-1][0] + 1;

        for(int i=1; i<=n1; i++){
            for(int j=1; j<=n2; j++){
                if(word1.charAt(i-1) == word2.charAt(j-1)) dp[i][j] = dp[i-1][j-1];
                else dp[i][j] = Math.min(Math.min(dp[i-1][j-1], dp[i][j-1]), dp[i-1][j]) + 1;
            }
        }
        return dp[n1][n2];
    }
}