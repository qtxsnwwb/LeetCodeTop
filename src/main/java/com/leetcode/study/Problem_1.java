package com.leetcode.study;

public class Problem_1 {
    public static void main(String[] args) {
        int[] nums = {2,7,11,15};
        int target = 9;
        int[] ans = new Solution_1().twoSum(nums, target);
        System.out.println(ans[0] + " " + ans[1]);
    }
}

/**
 * 两数之和
 */
class Solution_1 {
    public int[] twoSum(int[] nums, int target) {
        int[] ans = new int[2];
        if(nums.length <= 1) return ans;
        for(int i=0; i<nums.length-1; i++){
            for(int j=i+1; j<nums.length; j++){
                if(nums[i] + nums[j] == target){
                    ans[0] = i;
                    ans[1] = j;
                }
            }
        }
        return ans;
    }
}
