package com.leetcode.study;

import java.util.HashMap;
import java.util.Map;

public class Problem_169 {
    public static void main(String[] args) {
        int[] nums = {2,2,1,1,1,2,2};
        System.out.println(new Solution_169().majorityElement(nums));
    }
}

/**
 * 多数元素
 */
class Solution_169 {
    public int majorityElement(int[] nums) {
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<len; i++){
            int num = nums[i];
            if(!map.containsKey(num)) map.put(num, 1);
            else map.put(num, map.get(num) + 1);
            if(map.get(num) > len/2) return num;
        }
        return -1;
    }
}
