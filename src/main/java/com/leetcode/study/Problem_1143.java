package com.leetcode.study;

public class Problem_1143 {
    public static void main(String[] args) {
        String text1 = "abcde";
        String text2 = "ace";
        System.out.println(new Solution_1143().longestCommonSubsequence(text1, text2));
    }
}

/**
 * 最长公共子序列
 *
 *  二维动态规划
 *      dp[i][j]：text1[0:i] 和 text2[0:j] 的最长公共子序列的长度
 *      dp[i][j] = dp[i-1][j-1] + 1       text1[i-1] = text2[j-1]
 *                 max{dp[i-1][j], dp[i][j-1]}        text1[i-1] != text2[j-1]
 */
class Solution_1143 {
    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m+1][n+1];
        for(int i=1; i<=m; i++){
            char c1 = text1.charAt(i-1);
            for(int j=1; j<=n; j++){
                char c2 = text2.charAt(j-1);
                if(c1 == c2){
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }
}
