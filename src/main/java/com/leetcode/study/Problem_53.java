package com.leetcode.study;

public class Problem_53 {
    public static void main(String[] args) {
        int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(new Solution_53().maxSubArray(nums));
    }
}

/**
 * 最大子序和
 *
 * 动态规划
 *      依次判断每个数是否加入
 *      f(i) = max{f(i-1) + nums[i], nums[i]}
 */
class Solution_53 {
    public int maxSubArray(int[] nums) {
        int ans = nums[0];
        int sum = 0;
        for(int num : nums){
            if(sum > 0){
                sum += num;
            }else{
                sum = num;
            }
            ans = Math.max(ans, sum);
        }
        return ans;
    }
}