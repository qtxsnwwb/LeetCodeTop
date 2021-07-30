package com.leetcode.study;

public class Problem_42 {
    public static void main(String[] args) {
        int[] height = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(new Solution_42().trap(height));
    }
}

/**
 * 接雨水
 *
 * 解题：
 *      对任一位置，能接到的雨水量是由左右两侧最高柱子较矮的决定的
 */
class Solution_42 {
    public int trap(int[] height) {
        if(height.length < 3) return 0;
        int ans = 0;
        for(int i=0; i<height.length; i++){
            if(i == 0 || i == height.length-1) continue;    //跳过两头，不可能接到雨水
            int lHeight = 0, rHeight = 0;
            for(int j=0; j<i; j++){
                if(height[j] > lHeight) lHeight = height[j];     //找到左侧最高点
            }
            for(int j=i+1; j<height.length; j++){
                if(height[j] > rHeight) rHeight = height[j];     //找到右侧最高点
            }
            int h = Math.min(lHeight, rHeight) - height[i];
            if(h > 0) {
                ans += h;
            }
        }
        return ans;
    }
}
