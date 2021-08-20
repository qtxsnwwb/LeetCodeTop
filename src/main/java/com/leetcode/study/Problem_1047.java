package com.leetcode.study;

public class Problem_1047 {
    public static void main(String[] args) {
        String s = "abbaca";
        System.out.println(new Solution_1047().removeDuplicates(s));
    }
}

/**
 * 删除字符串中的所有相邻重复项
 *
 *  栈
 */
class Solution_1047 {
    public String removeDuplicates(String s) {
        StringBuffer stack = new StringBuffer();
        int top = -1;
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(top >= 0 && stack.charAt(top) == ch){
                stack.deleteCharAt(top);
                top--;
            }else{
                stack.append(ch);
                top++;
            }
        }
        return stack.toString();
    }
}
