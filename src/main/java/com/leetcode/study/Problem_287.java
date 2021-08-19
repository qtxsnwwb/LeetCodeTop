package com.leetcode.study;

import java.util.HashMap;
import java.util.Map;

public class Problem_287 {
    public static void main(String[] args) {
        int[] nums = {1,3,4,2,2};
        System.out.println(new Solution_287().findDuplicate(nums));
    }
}

/**
 * 寻找重复数
 */
class Solution_287 {
    public int findDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            if(map.containsKey(nums[i])) return nums[i];
            map.put(nums[i], 1);
        }
        return -1;
    }
}
