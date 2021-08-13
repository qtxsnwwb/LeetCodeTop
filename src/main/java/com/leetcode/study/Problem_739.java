package com.leetcode.study;

import java.util.Deque;
import java.util.LinkedList;

public class Problem_739 {
    public static void main(String[] args) {
        int[] temperature = {73,74,75,71,69,72,76,73};
        int[] ans = new Solution_739().dailyTemperatures(temperature);
        for(int i=0; i<ans.length; i++){
            System.out.print(ans[i] + " ");
        }
    }
}

/**
 * 每日温度
 *
 * 单调递减栈
 */
class Solution_739 {
    public int[] dailyTemperatures(int[] temperatures) {
        int length = temperatures.length;
        int[] ans = new int[length];
        Deque<Integer> stack = new LinkedList<>();
        for(int i=0; i<length; i++){
            int temperature = temperatures[i];
            while(!stack.isEmpty() && temperature > temperatures[stack.peek()]){
                int preIndex = stack.pop();
                ans[preIndex] = i - preIndex;
            }
            stack.push(i);
        }
        return ans;
    }
}
