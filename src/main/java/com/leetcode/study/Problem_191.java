package com.leetcode.study;

public class Problem_191 {
    public static void main(String[] args) {
        int n = 00000000000000000000000000001011;
        System.out.println(new Solution_191().hammingWeight(n));
    }
}

/**
 * 位 1 的个数
 */
class Solution_191 {
    public int hammingWeight(int n) {
        int bits = 0;
        int mask = 1;
        for(int i=0; i<32; i++){
            if((n & mask) != 0)
                bits++;
            mask <<= 1;
        }
        return bits;
    }
}
