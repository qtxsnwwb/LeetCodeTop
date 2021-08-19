package com.leetcode.study;

import java.util.Deque;
import java.util.LinkedList;

public class Problem_224 {
    public static void main(String[] args) {
        String s = "(1+(4+5+2)-3)+(6+8)";
        System.out.println(new Solution_224().calculate(s));
    }
}

/**
 * 基本计算器
 */
class Solution_224 {
    public int calculate(String s) {
        Deque<Integer> ops = new LinkedList<>();
        ops.push(1);
        int sign = 1;

        int ret = 0;
        int n = s.length();
        int i = 0;
        while(i < n){
            if(s.charAt(i) == ' '){
                i++;
            }else if(s.charAt(i) == '+'){
                sign = ops.peek();
                i++;
            }else if(s.charAt(i) == '-'){
                sign = -ops.peek();
                i++;
            }else if(s.charAt(i) == '('){
                ops.push(sign);
                i++;
            }else if(s.charAt(i) == ')'){
                ops.pop();
                i++;
            }else{
                long num = 0;
                while(i < n && Character.isDigit(s.charAt(i))){
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                ret += sign * num;
            }
        }
        return ret;
    }
}
