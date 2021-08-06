package com.leetcode.study;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class Problem_32 {
    public static void main(String[] args) {
        String s = ")()())";
        System.out.println(new Solution_32().longestValidParentheses(s));
    }
}

/**
 * 最长有效括号
 *
 *      始终保持栈底元素为当前已经遍历过的元素中 最后一个没有被匹配的右括号的下标
 *      对于遇到的每个'('，将其下标放入栈中
 *      对于遇到的每个')'，先弹出栈顶元素表示匹配了当前右括号：
 *          若栈为空，说明当前的右括号为没有被匹配的右括号，我们将其下标放入栈中更新之前提到的最后一个没有被匹配的右括号的下标
 *          若栈不为空，当前右括号的下标减去栈顶元素即为以该右括号为结尾的最长有效括号的长度
 */
class Solution_32 {
    public int longestValidParentheses(String s) {
        int maxans = 0;
        Deque<Integer> stack = new LinkedList<>();
        stack.push(-1);
        for(int i=0; i<s.length(); i++){
            if(s.charAt(i) == '('){
                stack.push(i);
            }else{
                stack.pop();
                if(stack.isEmpty()){
                    stack.push(i);
                }else{
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;
    }
}















