package com.leetcode.study;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem_15 {
    public static void main(String[] args) {
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> ans = new Solution_15().threeSum(nums);
        for(int i=0; i<ans.size(); i++){
            List<Integer> list = ans.get(i);
            for(int j=0; j<list.size(); j++){
                System.out.print(list.get(j) + " ");
            }
            System.out.println();
        }
    }
}

/**
 * 三数之和
 *
 * 解题：
 *      1、对数组排序，固定一个数nums[i]，双指针指向nums[i]后面的两端，分别为nums[L]、nums[R]，计算三数之和
 *          是否为0，满足则添加进结果集
 *      2、若nums[i]大于0，则必然无法等于0，结束循环
 *      3、若nums[i] == nums[i-1]，说明该数字重复，会导致结果重复，应该跳过
 *      4、当sum == 0时，nums[L] == nums[L+1]会导致结果重复，应该跳过，L++
 *      5、当sum == 0时，nums[R] == nums[R-1]会导致结果重复，应该跳过，R--
 */
class Solution_15 {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int len = nums.length;
        if(nums == null || len < 3) return ans;
        Arrays.sort(nums);     //排序
        for(int i=0; i<len; i++){
            if(nums[i] > 0) break;     //如果当前数字大于0，则三数之和一定大于0，所以结束循环
            if(i > 0 && nums[i] == nums[i-1]) continue;    //去重
            int L = i + 1;
            int R = len - 1;
            while(L < R){
                int sum = nums[i] + nums[L] + nums[R];
                if(sum == 0){
                    ans.add(Arrays.asList(nums[i], nums[L], nums[R]));
                    while(L < R && nums[L] == nums[L + 1]) L++;     //去重
                    while(L < R && nums[R] == nums[R - 1]) R--;     //去重
                    L++;
                    R--;
                }
                else if(sum < 0) L++;
                else if(sum > 0) R--;
            }
        }
        return ans;
    }
}













