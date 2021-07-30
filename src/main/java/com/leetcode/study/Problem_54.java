package com.leetcode.study;

import java.util.ArrayList;
import java.util.List;

public class Problem_54 {
    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        List<Integer> ans = new Solution_54().spiralOrder(matrix);
        for(Integer num : ans){
            System.out.print(num + " ");
        }
    }
}

/**
 * 螺旋矩阵
 */
class Solution_54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> order = new ArrayList<>();
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return order;
        }
        int rows = matrix.length, columns = matrix[0].length;
        int left = 0, right = columns - 1, top = 0, bottom = rows - 1;
        while(left <= right && top <= bottom){
            for(int column=left; column<=right; column++){
                order.add(matrix[top][column]);
            }
            for(int row=top+1; row<=bottom; row++){
                order.add(matrix[row][right]);
            }
            if(left < right && top < bottom){
                for(int column=right-1; column>left; column--){
                    order.add(matrix[bottom][column]);
                }
                for(int row=bottom; row>top; row--){
                    order.add(matrix[row][left]);
                }
            }
            left++;
            right--;
            top++;
            bottom--;
        }
        return order;
    }
}
