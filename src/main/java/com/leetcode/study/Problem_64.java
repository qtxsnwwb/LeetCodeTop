package com.leetcode.study;

public class Problem_64 {
    public static void main(String[] args) {
        int[][] grid = {
                {1,3,1},
                {1,5,1},
                {4,2,1}
        };
        System.out.println(new Solution_64().minPathSum(grid));
    }
}

/**
 * 最小路径和
 *
 *  动态规划
 *      到达每个网格的最小路径等于左和上网格的最短路径的较小值加本网格的值
 *          dp[i][j] = min{dp[i-1][j], dp[i][j-1]} + grid[i][j]
 */
class Solution_64 {
    public int minPathSum(int[][] grid) {
        int row = grid.length, col = grid[0].length;
        int[][] dp = new int[row][col];
        dp[0][0] = grid[0][0];
        for(int i=1; i<row; i++){
            dp[i][0] = dp[i-1][0] + grid[i][0];
        }
        for(int j=1; j<col; j++){
            dp[0][j] = dp[0][j-1] + grid[0][j];
        }
        for(int i=1; i<row; i++){
            for(int j=1; j<col; j++){
                dp[i][j] = Math.min(dp[i-1][j], dp[i][j-1]) + grid[i][j];
            }
        }
        return dp[row-1][col-1];
    }
}
