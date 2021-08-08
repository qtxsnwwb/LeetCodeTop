package com.leetcode.study;

import java.util.ArrayList;
import java.util.List;

public class Problem_39 {
    public static void main(String[] args) {
        int[] candidates = {2,3,6,7};
        int target = 7;
        List<List<Integer>> ans = new Solution_39().combinationSum(candidates, target);
        for(List<Integer> list : ans){
            for(Integer num : list){
                System.out.print(num + " ");
            }
            System.out.println();
        }
    }
}

/**
 * 组合总和
 *
 * 搜索回溯
 */
class Solution_39 {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> combine = new ArrayList<>();
        dfs(candidates, target, ans, combine, 0);
        return ans;
    }

    public void dfs(int[] candidates, int target, List<List<Integer>> ans, List<Integer> combine, int idx) {
        if(idx == candidates.length) return;
        if(target == 0){
            ans.add(new ArrayList<>(combine));
            return;
        }
        dfs(candidates, target, ans, combine, idx+1);
        //回溯
        if(target - candidates[idx] >= 0){
            combine.add(candidates[idx]);
            dfs(candidates, target - candidates[idx], ans, combine, idx);
            combine.remove(combine.size() - 1);
        }
    }
}
