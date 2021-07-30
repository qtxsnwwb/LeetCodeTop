package com.leetcode.study;

import java.util.Arrays;

public class Problem_31 {
    public static void main(String[] args) {
        int[] nums = {1,1,5};
        new Solution_31().nextPermutation(nums);
        for(int i=0; i<nums.length; i++){
            System.out.print(nums[i] + " ");
        }
    }
}

/**
 * 下一个排列
 *
 * 解题：
 *      1、在尽可能靠右的低位进行交换，需要从后向前查找
 *      2、将一个尽可能小的大数与前面的小数交换
 *      3、将大数换到前面后，需要将大数后面的所有数重置为升序，升序排列就是最小的排列
 * 步骤：
 *      1、从后向前查找第一个相邻升序的元素对 (i, j)，满足 A[i] < A[j]。此时 [j, end] 必然是降序
 *      2、在 [j, end] 从后向前查找第一个满足 A[i] < A[k] 的 k。A[i] 和 A[k]分别就是小数和大数
 *      3、将 A[i] 与 A[k] 交换
 *      4、可以断定这时 [j, end]必然是降序，逆置 [j, end]，使其升序
 *      5、如果步骤 1 找不到符合的相邻元素对，说明当前 [begin, end) 为一个降序顺序，则直接跳到步骤 4
 */
class Solution_31 {
    public void nextPermutation(int[] nums) {
        int len = nums.length;
        for(int i=len-1; i>0; i--){
            if(nums[i] > nums[i-1]){
                Arrays.sort(nums, i, len);
                for(int j=i; j<len; j++){
                    if(nums[j] > nums[i-1]){
                        int temp = nums[j];
                        nums[j] = nums[i-1];
                        nums[i-1] = temp;
                        return;
                    }
                }
            }
        }
        Arrays.sort(nums);
        return;
    }
}
