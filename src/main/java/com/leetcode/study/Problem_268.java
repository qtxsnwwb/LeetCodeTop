package com.leetcode.study;

import java.util.Arrays;

public class Problem_268 {
    public static void main(String[] args) {
        int[] nums = {3,0,1};
        System.out.println(new Solution_268().missingNumber(nums));
    }
}

/**
 * 丢失的数字
 */
class Solution_268 {
    public int missingNumber(int[] nums) {
        Arrays.sort(nums);

        //判断 n 是否出现在末位
        if(nums[nums.length-1] != nums.length)
            return nums.length;
        //判断 0 是否出现在首位
        else if(nums[0] != 0)
            return 0;

        //此时缺失的数字一定在（0，n）中
        for(int i=1; i<nums.length; i++){
            int expectedNum = nums[i - 1] + 1;
            if(nums[i] != expectedNum)
                return expectedNum;
        }

        //未缺失任何数字
        return -1;
    }
}
