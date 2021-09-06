package com.leetcode.study;

public class Problem_153 {
    public static void main(String[] args) {
        int[] nums = {3,4,5,1,2};
        System.out.println(new Solution_153().findMin(nums));
    }
}

/**
 * 寻找旋转排序数组中的最小值
 *
 *  二分查找
 */
class Solution_153 {
    public int findMin(int[] nums) {
        int low = 0;
        int high = nums.length - 1;
        while(low < high){
            int pivot = low + (high - low) / 2;
            if(nums[pivot] < nums[high]){
                high = pivot;
            }else{
                low = pivot + 1;
            }
        }
        return nums[low];
    }
}
