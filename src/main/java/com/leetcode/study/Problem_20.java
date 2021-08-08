package com.leetcode.study;

import java.util.Stack;

public class Problem_20 {
    public static void main(String[] args) {
        String s = "{[]}";
        System.out.println(new Solution_20().isValid(s));
    }
}

/**
 * 有效的括号
 *
 * 栈
 */
class Solution_20 {
    public boolean isValid(String s) {
        if(s.length() == 0){
            return true;
        }
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        for(int i=0; i<chars.length; i++){
            char letter = chars[i];
            if(letter == '(' || letter == '[' || letter == '{'){
                stack.push(letter);
            }else{
                if(stack.isEmpty()){
                    return false;
                }
                char top = stack.pop();    //栈顶元素，出栈
                if((letter == ')' && top == '(') || (letter == ']' && top == '[') || (letter == '}' && top == '{')){
                    continue;
                }else{
                    return false;
                }
            }
        }
        //判断是否还有残余，例如'('
        return stack.isEmpty();
    }
}
