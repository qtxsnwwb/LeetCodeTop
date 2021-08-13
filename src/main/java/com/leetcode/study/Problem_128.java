package com.leetcode.study;

import java.util.HashSet;
import java.util.Set;

public class Problem_128 {
    public static void main(String[] args) {
        int[] nums = {100,4,200,1,3,2};
        System.out.println(new Solution_128().longestConsecutive(nums));;
    }
}

/**
 * 最长连续序列
 */
class Solution_128 {
    public int longestConsecutive(int[] nums) {
        Set<Integer> nums_set = new HashSet<>();
        for(int num : nums){
            nums_set.add(num);
        }
        int longestStreak = 0;
        for(int num : nums_set){
            if(!nums_set.contains(num - 1)){
                int currentNum = num;
                int currentStreak = 1;
                while(nums_set.contains(currentNum + 1)){
                    currentNum += 1;
                    currentStreak += 1;
                }
                longestStreak = Math.max(longestStreak, currentStreak);
            }
        }
        return longestStreak;
    }
}
