package com.leetcode.study;

public class Problem_11 {
    public static void main(String[] args) {
        int[] height = {1,8,6,2,5,4,8,3,7};
        System.out.println(new Solution_11().maxArea(height));
    }
}

/**
 * 盛最多水的容器
 *
 *  双指针
 *      每次移动较小的一边的指针
 */
class Solution_11 {
    public int maxArea(int[] height) {
        int l = 0, r = height.length - 1;
        int ans = 0;
        while(l < r){
            int area = Math.min(height[l], height[r]) * (r - l);
            ans = Math.max(ans, area);
            if(height[l] <= height[r]) l++;
            else r--;
        }
        return ans;
    }
}
