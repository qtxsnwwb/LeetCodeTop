package com.leetcode.study;

public class Problem_136 {
    public static void main(String[] args) {
        int[] nums = {4,1,2,1,2};
        System.out.println(new Solution_136().singleNumber(nums));
    }
}

/**
 * 只出现一次的数字
 */
class Solution_136 {
    public int singleNumber(int[] nums) {
        int ans = 0;
        for(int num : nums){
            ans ^= num;
        }
        return ans;
    }
}