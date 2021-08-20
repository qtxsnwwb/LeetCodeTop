package com.leetcode.study;

public class Problem_50 {
    public static void main(String[] args) {
        double x = 2.0000;
        int n = 10;
        System.out.println(new Solution_50().myPow(x, n));
    }
}

/**
 * Pow(x, n)
 */
class Solution_50 {
    public double myPow(double x, int n) {
        long N = n;
        return N >= 0 ? quickMul(x, N) : 1.0 / quickMul(x, -N);
    }

    private double quickMul(double x, long N) {
        if(N == 0) return 1.0;
        double y = quickMul(x, N / 2);
        return N % 2 == 0 ? y * y : y * y * x;
    }
}













