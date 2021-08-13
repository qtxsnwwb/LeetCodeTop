package com.leetcode.study;

public class Problem_69 {
    public static void main(String[] args) {
        int x = 8;
        System.out.println(new Solution_69().mySqrt(x));
    }
}

class Solution_69 {
    public int mySqrt(int x) {
        return (int) Math.sqrt(x);
    }
}
