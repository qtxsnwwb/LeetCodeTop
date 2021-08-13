package com.leetcode.study;

import java.util.ArrayList;
import java.util.List;

public class Problem_78 {
    public static void main(String[] args) {
        int[] nums = {1,2,3};
        List<List<Integer>> ans = new Solution_78().subsets(nums);
        for(List<Integer> list : ans){
            for(Integer num : list){
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}

class Solution_78 {
    List<List<Integer>> ans = new ArrayList<>();
    List<Integer> list = new ArrayList<>();

    public List<List<Integer>> subsets(int[] nums) {
        dfs(0, nums);
        return ans;
    }

    private void dfs(int cur, int[] nums) {
        if(cur == nums.length){
            ans.add(new ArrayList<>(list));
            return;
        }
        list.add(nums[cur]);
        dfs(cur+1, nums);
        list.remove(list.size()-1);
        dfs(cur+1, nums);
    }
}
