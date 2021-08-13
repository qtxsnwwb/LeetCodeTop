package com.leetcode.study;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Problem_22 {
    public static void main(String[] args) {
        int n = 3;
        List<String> ans = new Solution_22().generateParenthesis(n);
        for(String str : ans){
            System.out.println(str + " ");
        }
    }
}

/**
 * 括号生成
 *
 * 回溯法
 *      1、当前左右括号都有大于 0 个可以使用的时候，才产生分支
 *      2、产生左分支的时候，只看当前是否还有左括号可以使用
 *      3、产生右分支的时候，还受到左分支的限制，右边剩余可以使用的括号数量一定得在严格大于左边剩余数量的时候，才可以产生分支
 *      4、在左边和右边剩余的括号数都等于 0 的时候结算
 */
class Solution_22 {

    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        if(n == 0) return ans;
        dfs(ans, n, n, "");
        return ans;
    }

    private void dfs(List<String> ans, int left, int right, String str) {
        if(left == 0 && right == 0){
            ans.add(str);
            return;
        }
        //剪枝，左括号可以使用的个数严格大于右括号可以使用的个数，才剪枝
        if(left > right) return;
        if(left > 0){
            dfs(ans, left-1, right, str + "(");
        }
        if(right > 0){
            dfs(ans, left, right-1, str + ")");
        }
    }
}
