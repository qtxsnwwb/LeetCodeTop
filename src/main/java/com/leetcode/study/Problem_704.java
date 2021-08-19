package com.leetcode.study;

public class Problem_704 {
    public static void main(String[] args) {
        int[] nums = {-1,0,3,5,9,12};
        int target = 9;
        System.out.println(new Solution_704().search(nums, target));
    }
}

/**
 * 二分查找
 */
class Solution_704 {
    public int search(int[] nums, int target) {
        int l = 0, r = nums.length - 1;
        while(l <= r){
            int mid = (l + r) / 2;
            if(nums[mid] == target) return mid;
            else if(nums[mid] < target) l = mid + 1;
            else r = mid - 1;
        }
        return -1;
    }
}
