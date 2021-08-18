package com.leetcode.study;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Problem_695 {
    public static void main(String[] args) {
        int[][] grid = {
                {1,1,0,0,0},
                {1,1,0,0,0},
                {0,0,0,1,1},
                {0,0,0,1,1},

        };
        System.out.println(new Solution_695().maxAreaOfIsland(grid));
    }
}

/**
 * 岛屿的最大面积
 */
class Solution_695 {
    public int maxAreaOfIsland(int[][] grid) {
        if(grid.length == 0 || grid[0].length == 0) return 0;
        int rowNum = grid.length, colNum = grid[0].length;
        boolean[][] visited = new boolean[rowNum][colNum];
        int ans = 0;
        for(int i=0; i<rowNum; i++){
            for(int j=0; j<colNum; j++){
                if(grid[i][j] == 1 && !visited[i][j]){
                    int result = dfs(i, j, rowNum, colNum, grid, visited);
                    ans = Math.max(ans, result);
                }
            }
        }
        return ans;
    }

    //深度优先遍历
    private int dfs(int curRow, int curCol, int rowNum, int colNum, int[][] grid, boolean[][] visited) {
        int sum = 0;
        List<Integer> list = new ArrayList<>();
        list.add(curRow);
        list.add(curCol);
        Stack<List<Integer>> stack = new Stack<>();
        stack.push(list);
        visited[curRow][curCol] = true;
        while(!stack.isEmpty()){
            List<Integer> top = stack.pop();
            int row = top.get(0);
            int col = top.get(1);
            sum++;
            if(row >= 1 && grid[row-1][col] == 1 && !visited[row-1][col]){
                List<Integer> temp = new ArrayList<>();
                temp.add(row-1);
                temp.add(col);
                stack.push(temp);
                visited[row-1][col] = true;
            }
            if(row < rowNum-1 && grid[row+1][col] == 1 && !visited[row+1][col]){
                List<Integer> temp = new ArrayList<>();
                temp.add(row+1);
                temp.add(col);
                stack.push(temp);
                visited[row+1][col] = true;
            }
            if(col >= 1 && grid[row][col-1] == 1 && !visited[row][col-1]){
                List<Integer> temp = new ArrayList<>();
                temp.add(row);
                temp.add(col-1);
                stack.push(temp);
                visited[row][col-1] = true;
            }
            if(col < colNum-1 && grid[row][col+1] == 1 && !visited[row][col+1]){
                List<Integer> temp = new ArrayList<>();
                temp.add(row);
                temp.add(col+1);
                stack.push(temp);
                visited[row][col+1] = true;
            }
        }
        return sum;
    }
}
