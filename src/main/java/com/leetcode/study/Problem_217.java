package com.leetcode.study;

import java.util.HashMap;
import java.util.Map;

public class Problem_217 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        System.out.println(new Solution_217().containsDuplicate(nums));
    }
}

/**
 * 存在重复元素
 */
class Solution_217 {
    public boolean containsDuplicate(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums.length; i++){
            if(!map.containsKey(nums[i])){
                map.put(nums[i], 1);
            }else{
                return true;
            }
        }
        return false;
    }
}
