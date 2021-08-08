package com.leetcode.study;

import java.util.HashMap;
import java.util.Map;

public class Problem_41 {
    public static void main(String[] args) {
        int[] nums = {3,4,-1,1};
        System.out.println(new Solution_41().firstMissingPositive(nums));
    }
}

/**
 * 缺失的第一个正数
 *
 * 解题：
 *      哨兵原理，使用哈希表记录所有数字，再设置一个哨兵从 1 开始，
 *      依次判断每个正整数是否在哈希表中，若不在则哨兵的当前位置就是所求，若在则向后移动一个位置（哨兵++）
 */
class Solution_41 {
    public int firstMissingPositive(int[] nums) {
        int n = nums.length;
        if(n == 0) return 1;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++){
            map.put(nums[i], 1);
        }
        int ans = 1;
        for(int i=0; i<n; i++){
            if(!map.containsKey(ans)) return ans;
            ans++;
        }
        return ans;
    }
}
