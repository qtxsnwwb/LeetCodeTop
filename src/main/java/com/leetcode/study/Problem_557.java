package com.leetcode.study;

public class Problem_557 {
    public static void main(String[] args) {
        String s = "Let's take LeetCode contest";
        System.out.println(new Solution_557().reverseWords(s));
    }
}

/**
 * 反转字符串中的单词 3
 */
class Solution_557 {
    public String reverseWords(String s) {
        String[] splitStr = s.split(" ");
        StringBuffer str = new StringBuffer("");
        for(int i=0; i<splitStr.length; i++){
            String num = splitStr[i];
            for(int j=num.length()-1; j>=0; j--){
                str.append(num.charAt(j));
            }
            if(i != splitStr.length-1)
                str.append(" ");
        }
        return str.toString();
    }
}