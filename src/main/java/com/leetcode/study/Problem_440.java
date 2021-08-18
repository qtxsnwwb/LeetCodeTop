package com.leetcode.study;

public class Problem_440 {
    public static void main(String[] args) {
        int n = 13, k = 2;
        System.out.println(new Solution_440().findKthNumber(n, k));
    }
}

/**
 * 字典序的第 K 小数字
 *
 *  1. 确定指定前缀下所有子节点数
 *  2. 第 k 个数在当前前缀下
 *      prefix *= 10
 *  3. 第 k 个数不在当前前缀下
 *      prefix++
 */
class Solution_440 {
    public int findKthNumber(int n, int k) {
        long cur = 1;
        k--;
        while(k > 0){
            int nodes = getNodes(n, cur);
            if(k >= nodes){
                k -= nodes;
                cur++;
            }else{
                k -= 1;
                cur *= 10;
            }
        }
        return (int)cur;
    }

    private int getNodes(int n, long cur){
        long next = cur + 1;
        long totalNodes = 0;
        while(cur <= n){
            totalNodes += Math.min(n - cur + 1, next - cur);
            next *= 10;
            cur *= 10;
        }
        return (int)totalNodes;
    }
}
