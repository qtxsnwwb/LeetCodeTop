package com.leetcode.study;

public class Problem_509 {
    public static void main(String[] args) {
        int n = 3;
        System.out.println(new Solution_509().fib(n));
    }
}

/**
 * 斐波那契数
 */
class Solution_509 {
    public int fib(int n) {
        if(n == 0) return 0;
        if(n == 1) return 1;
        return fib(n - 1) + fib(n - 2);
    }
}
