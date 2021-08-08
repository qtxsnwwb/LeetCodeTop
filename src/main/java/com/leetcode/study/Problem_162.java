package com.leetcode.study;

public class Problem_162 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        System.out.println(new Solution_162().findPeakElement(nums));
    }
}

/**
 * 寻找峰值
 */
class Solution_162 {
    public int findPeakElement(int[] nums) {
        if(nums.length == 1) return 0;
        for(int i=0; i<nums.length; i++){
            if(i == 0) {
                if(nums[i] > nums[i+1]) return i;
                continue;
            }
            if(i == nums.length-1){
                if(nums[i] > nums[i-1]) return i;
                continue;
            }
            if(nums[i] > nums[i-1] && nums[i] > nums[i+1]) return i;
        }
        return -1;
    }
}
