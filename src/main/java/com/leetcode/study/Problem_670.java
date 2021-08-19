package com.leetcode.study;

public class Problem_670 {
    public static void main(String[] args) {
        int num = 2736;
        System.out.println(new Solution_670().maximumSwap(num));
    }
}

/**
 * 最大交换
 *
 *  贪心算法
 *      将计算 last[d] = i，最后一次出现的数字 d 的索引 i
 *      然后，从左到右扫描数字时，如果将来有较大的数字，我们将用最大的数字交换；如果有多个这样的数字，我们将用最开始遇到的数字交换
 */
class Solution_670 {
    public int maximumSwap(int num) {
        String s = String.valueOf(num);
        int len = s.length();
        char[] charArray = s.toCharArray();

        //记录每个数字出现的最后一次出现的下标
        int[] last = new int[10];
        for(int i=0; i<len; i++){
            last[charArray[i] - '0'] = i;
        }

        //从左向右扫描，找到当前位置右边的最大的数字并交换
        for(int i=0; i<len-1; i++){
            //找最大，所以倒着找
            for(int d=9; d>charArray[i]-'0'; d--){
                if(last[d] > i){
                    swap(charArray, i, last[d]);
                    //只允许交换一次，因此直接返回
                    return Integer.parseInt(new String(charArray));
                }
            }
        }
        return num;
    }

    private void swap(char[] charArray, int index1, int index2) {
        char temp = charArray[index1];
        charArray[index1] = charArray[index2];
        charArray[index2] = temp;
    }
}
