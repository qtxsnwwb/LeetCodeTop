package com.leetcode.study;

public class Problem_560 {
    public static void main(String[] args) {
        int[] nums = {1,1,1};
        int k = 2;
        System.out.println(new Solution_560().subarraySum(nums, k));
    }
}

/**
 * 和为 K 的子数组
 */
class Solution_560 {
    public int subarraySum(int[] nums, int k) {
        int count = 0;
        for(int start=0; start<nums.length; start++){
            int sum = 0;
            for(int end=start; end >=0; end--){
                sum += nums[end];
                if(sum == k) count++;
            }
        }
        return count;
    }
}
