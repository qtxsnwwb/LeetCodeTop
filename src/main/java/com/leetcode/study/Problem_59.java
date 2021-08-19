package com.leetcode.study;

public class Problem_59 {
    public static void main(String[] args) {
        int n = 3;
        int[][] ans = new Solution_59().generateMatrix(n);
        for(int i=0; i<ans.length; i++){
            for(int j=0; j<ans[0].length; j++){
                System.out.print(ans[i][j] + " ");
            }
            System.out.println();
        }
    }
}

/**
 * 螺旋矩阵 2
 */
class Solution_59 {
    public int[][] generateMatrix(int n) {
        int num = 1;
        int[][] matrix = new int[n][n];
        int left = 0, right = n - 1, top = 0, bottom = n - 1;
        while(left <= right && top <= bottom){
            for(int column = left; column <= right; column++){
                matrix[top][column] = num;
                num++;
            }
            for(int row = top + 1; row <= bottom; row++){
                matrix[row][right] = num;
                num++;
            }
            if(left < right && top < bottom){
                for(int column = right - 1; column > left; column--){
                    matrix[bottom][column] = num;
                    num++;
                }
                for(int row = bottom; row > top; row--){
                    matrix[row][left] = num;
                    num++;
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return matrix;
    }
}
