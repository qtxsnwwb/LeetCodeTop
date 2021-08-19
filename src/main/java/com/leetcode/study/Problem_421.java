package com.leetcode.study;

import java.util.HashSet;
import java.util.Set;

public class Problem_421 {
    public static void main(String[] args) {
        int[] nums = {3,10,5,25,2,8};
        System.out.println(new Solution_421().findMaximumXOR(nums));
    }
}

/**
 * 数组中两个数的最大异或值
 *
 *  哈希表
 */
class Solution_421 {

    //最高位的二进制位编号为 30
    static final int HIGH_BIT = 30;

    public int findMaximumXOR(int[] nums) {
        int x = 0;
        for(int k=HIGH_BIT; k>=0; k--){
            Set<Integer> seen = new HashSet<>();
            for(int num : nums){
                seen.add(num >> k);
            }

            int xNext = x * 2 + 1;
            boolean found = false;

            for(int num : nums){
                if(seen.contains(xNext ^ (num >> k))){
                    found = true;
                    break;
                }
            }

            if(found){
                x = xNext;
            }else{
                x = xNext - 1;
            }
        }
        return x;
    }
}
