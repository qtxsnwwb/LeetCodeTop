package com.leetcode.study;

public class Problem_209 {
    public static void main(String[] args) {
        int target = 7;
        int[] nums = {2,3,1,2,4,3};
        System.out.println(new Solution_209().minSubArrayLen(target, nums));
    }
}

/**
 * 长度最小的子数组
 *
 *  滑动窗口
 *      1、使用双指针 start 和 end，end不断往后滑动，求和
 *      2、当 sum >= target 时，将连续子数组的长度保存在变量 ans 中，然后减掉当前窗口的第一个元素，然后将 start 右移，直到 sum < target
 */
class Solution_209 {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        if(n == 0) return 0;
        int ans = Integer.MAX_VALUE;
        int start = 0;
        int end = 0;
        int sum = 0;
        while(end < n){
            sum += nums[end];
            while(sum >= target){
                ans = Math.min(ans, end - start + 1);
                sum -= nums[start];
                start++;
            }
            end++;
        }
        return ans == Integer.MAX_VALUE ? 0 : ans;
    }
}
