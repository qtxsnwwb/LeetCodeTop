package com.leetcode.study;

public class Problem_240 {
    public static void main(String[] args) {
        int[][] matrix = {
                {1,4,7,11,15},
                {2,5,8,12,19},
                {3,6,9,16,22},
                {10,13,14,17,24},
                {18,21,23,26,30}
        };
        int target = 5;
        System.out.println(new Solution_240().searchMatrix(matrix, target));
    }
}

/**
 * 搜索二维矩阵 2
 */
class Solution_240 {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0) return false;
        return search(matrix, target, matrix.length-1, 0);
    }

    private boolean search(int[][] matrix, int target, int row, int col) {
        if(matrix[row][col] == target) return true;
        else if(matrix[row][col] < target){
            if(col != matrix[0].length-1){
                return search(matrix, target, row, col+1);
            }
        }else{
            if(row != 0){
                return search(matrix, target, row-1, col);
            }
        }
        return false;
    }
}
