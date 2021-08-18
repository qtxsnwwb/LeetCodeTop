package com.leetcode.study;

import java.util.Arrays;

public class Problem_556 {
    public static void main(String[] args) {
        int n = 12;
        System.out.println(new Solution_556().nextGreaterElement(n));
    }
}

/**
 * 下一个更大元素 3
 */
class Solution_556 {
    public int nextGreaterElement(int n) {
        String num = String.valueOf(n);
        char[] chs = num.toCharArray();
        int len = chs.length;

        int index = -1;
        //从后向前查找
        for(int i=len-1; i>=0 && index==-1; i--){
            int j = i - 1;
            //找到一对符合条件的num[i]，num[i-1]
            if(j >= 0 && chs[i] > chs[j]){
                for(int k=len-1; k>=i; k--){
                    if(chs[k] > chs[j]){
                        char temp = chs[j];
                        chs[j] = chs[k];
                        chs[k] = temp;
                        index = i;
                        break;
                    }
                }
            }
        }
        if(index == -1) return -1;

        //将index之后的元素从小到大排序
        Arrays.sort(chs, index, len);

        //构建结果
        long res = 0;
        for(int i=0; i<len; i++)
            res = res * 10 + (chs[i] - '0');

        return res > Integer.MAX_VALUE ? -1 : (int)(res);
    }
}
