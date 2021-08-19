package com.leetcode.study;

public class Problem_135 {
    public static void main(String[] args) {
        int[] ratings = {1,0,2};
        System.out.println(new Solution_135().candy(ratings));
    }
}

/**
 * 分发糖果
 */
class Solution_135 {
    public int candy(int[] ratings) {
        int n = ratings.length;
        int[] left = new int[n];
        for(int i=0; i<n; i++){
            if(i>0 && ratings[i]>ratings[i-1]){
                left[i] = left[i - 1] + 1;
            }else{
                left[i] = 1;
            }
        }
        int right = 0, ret = 0;
        for(int i=n-1; i>=0; i--){
            if(i<n-1 && ratings[i]>ratings[i+1]){
                right++;
            }else{
                right = 1;
            }
            ret += Math.max(left[i], right);
        }
        return ret;
    }
}