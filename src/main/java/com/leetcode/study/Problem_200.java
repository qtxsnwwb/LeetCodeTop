package com.leetcode.study;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Problem_200 {
    public static void main(String[] args) {
        char[][] grid = {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };
        System.out.println(new Solution_200().numIslands(grid));
    }
}

/**
 * 岛屿数量
 *
 * 解题：
 *      深度优先遍历
 *      通过 visited 数组保证不重复访问，利用深度优先遍历找到一个岛屿涉及的所有陆地，网格遍历完即可找到所有岛屿
 */
class Solution_200 {
    public int numIslands(char[][] grid) {
        if(grid.length == 0) return 0;
        int row = grid.length;
        int col = grid[0].length;
        int ans = 0;
        boolean[][] visited = new boolean[row][col];
        for(int i=0; i<row; i++){
            for(int j=0; j<col; j++){
                if(!visited[i][j] && grid[i][j] == '1'){     //若未访问
                    ans++;
                    dfs(grid, visited, i, j, row, col);
                }
            }
        }
        return ans;
    }

    //深度优先遍历
    private void dfs(char[][] grid, boolean[][] visited, int curRow, int curCol, int rowMax, int colMax) {
        Stack<List<Integer>> stack = new Stack<>();
        List<Integer> list = new ArrayList<>();
        list.add(curRow);
        list.add(curCol);
        stack.push(list);
        while(!stack.isEmpty()){
            List<Integer> top = stack.pop();
            int row = top.get(0);
            int col = top.get(1);
            visited[row][col] = true;
            if(row >= 1 && grid[row-1][col] == '1' && !visited[row-1][col]){
                List<Integer> temp = new ArrayList<>();
                temp.add(row-1);
                temp.add(col);
                stack.push(temp);
            }
            if(row < rowMax-1 && grid[row+1][col] == '1' && !visited[row+1][col]){
                List<Integer> temp = new ArrayList<>();
                temp.add(row+1);
                temp.add(col);
                stack.push(temp);
            }
            if(col >= 1 && grid[row][col-1] == '1' && !visited[row][col-1]){
                List<Integer> temp = new ArrayList<>();
                temp.add(row);
                temp.add(col-1);
                stack.push(temp);
            }
            if(col < colMax-1 && grid[row][col+1] == '1' && !visited[row][col+1]){
                List<Integer> temp = new ArrayList<>();
                temp.add(row);
                temp.add(col+1);
                stack.push(temp);
            }
        }
    }
}
















