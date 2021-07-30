package com.leetcode.study;

public class Problem_33 {
    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        int target = 0;
        System.out.println(new Solution_33().search(nums, target));
    }
}

/**
 * 搜索旋转排序数组
 *
 * 解题：
 *      二分查找
 */
class Solution_33 {
    public int search(int[] nums, int target) {
        int n = nums.length;
        if(n == 0) return -1;
        if(n == 1) return nums[0] == target ? 0 : -1;
        int left = 0, right = n-1;
        while(left <= right) {
            int middle = (left + right) / 2;
            if(nums[middle] == target) return middle;
            //左侧有序
            if(nums[0] <= nums[middle]){
                if(nums[0] <= target && target < nums[middle]){
                    right = middle - 1;
                }else{
                    left = middle - 1;
                }
            }else{     //右侧有序
                if(nums[middle] < target && target <= nums[n-1]){
                    left = middle + 1;
                }else{
                    right = middle - 1;
                }
            }
        }
        return -1;
    }
}
