package com.leetcode.study;

import java.util.ArrayDeque;
import java.util.Deque;

public class Problem_151 {
    public static void main(String[] args) {
        String s = "the sky is blue";
        System.out.println(new Solution_151().reverseWords(s));
    }
}

/**
 * 翻转字符串里的单词
 *
 *  双端队列
 */
class Solution_151 {
    public String reverseWords(String s) {
        int left = 0, right = s.length() - 1;
        //去掉字符串开头的空白字符
        while(left <= right && s.charAt(left) == ' ') left++;
        //去掉字符串末尾的空白字符
        while(left <= right && s.charAt(right) == ' ') right--;

        Deque<String> d = new ArrayDeque<>();
        StringBuilder word = new StringBuilder();

        while(left <= right){
            char c = s.charAt(left);
            if((word.length() != 0) && (c == ' ')){
                //将单词 push 到队列的头部
                d.offerFirst(word.toString());
                word.setLength(0);
            }else if(c != ' '){
                word.append(c);
            }
            left++;
        }
        d.offerFirst(word.toString());

        return String.join(" ", d);
    }
}
