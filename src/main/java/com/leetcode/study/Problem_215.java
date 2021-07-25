package com.leetcode.study;

public class Problem_215 {
    public static void main(String[] args) {
        int[] nums = {3,2,1,5,6,4};
        int k = 2;
        System.out.println(new Solution_215().findKthLargest(nums, k));
    }
}

/**
 * 数组中的第K个最大元素
 */
class Solution_215 {
    public int findKthLargest(int[] nums, int k) {
        quick_sort(nums, 0, nums.length-1);
        return nums[nums.length-k];
    }

    //快速排序
    private void quick_sort(int s[], int l, int r){
        if(l < r){
            int i = l, j = r, x = s[l];
            while(i < j){
                while(i < j && s[j] >= x)   //从右向左找第一个小于x的数
                    j--;
                if(i < j)
                    s[i++] = s[j];
                while(i < j && s[i] < x)    //从左向右找第一个大于等于x的数
                    i++;
                if(i < j)
                    s[j--] = s[i];
            }
            s[i] = x;
            quick_sort(s, l, i-1);
            quick_sort(s, i+1, r);
        }
    }
}
