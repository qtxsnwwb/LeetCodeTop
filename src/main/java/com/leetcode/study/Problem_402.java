package com.leetcode.study;

import java.util.Deque;
import java.util.LinkedList;

public class Problem_402 {
    public static void main(String[] args) {
        String num = "1432219";
        int k = 3;
        System.out.println(new Solution_402().removeKdigits(num, k));
    }
}

/**
 * 移掉 K 位数字
 *
 *  贪心 + 单调栈
 *      保证靠前的数字尽可能小
 *          贪心策略：
 *              给定一个长度为 n 的数字序列 [D0 D1 D2 D3 ... Dn-1]，从左往右找到第一个位置 i，使得 Di < Di-1，
 *              并删除 Di-1；如果不存在，说明整个数字序列单调不降，删去最后一个数字即可
 *          每次对整个数字序列执行一次这个策略；删去一个字符后，剩下的 n - 1 长度的数字序列就形成了新的子问题
 *          可以继续使用同样的策略，直到删除 k 次
 */
class Solution_402 {
    public String removeKdigits(String num, int k) {
        Deque<Character> deque = new LinkedList<>();
        int length = num.length();
        for(int i=0; i<length; i++){
            char digit = num.charAt(i);
            while(!deque.isEmpty() && k > 0 && deque.peekLast() > digit){
                deque.pollLast();
                k--;
            }
            deque.offerLast(digit);
        }
        for(int i=0; i<k; i++){
            deque.pollLast();
        }

        StringBuffer ret = new StringBuffer();
        boolean leadingZero = true;
        while(!deque.isEmpty()){
            char digit = deque.pollFirst();
            if(leadingZero && digit == '0') continue;
            leadingZero = false;
            ret.append(digit);
        }
        return ret.length() == 0 ? "0" : ret.toString();
    }
}



























