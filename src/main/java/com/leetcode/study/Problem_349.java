package com.leetcode.study;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Problem_349 {
    public static void main(String[] args) {
        int[] nums1 = {4,9,5};
        int[] nums2 = {9,4,9,8,4};
        int[] ans = new Solution_349().intersection(nums1, nums2);
        for(int i=0; i<ans.length; i++){
            System.out.print(ans[i] + " ");
        }
    }
}

/**
 * 两个数组的交集
 */
class Solution_349 {
    public int[] intersection(int[] nums1, int[] nums2) {
        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0; i<nums1.length; i++){
            if(!map.containsKey(nums1[i]))
                map.put(nums1[i], 1);
        }
        for(int i=0; i<nums2.length; i++){
            if(map.containsKey(nums2[i])) {
                list.add(nums2[i]);
                map.remove(nums2[i]);
            }
        }
        int[] ans = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            ans[i] = list.get(i);
        }
        return ans;
    }
}
