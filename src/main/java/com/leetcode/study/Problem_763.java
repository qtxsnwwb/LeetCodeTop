package com.leetcode.study;

import java.util.ArrayList;
import java.util.List;

public class Problem_763 {
    public static void main(String[] args) {
        String s = "ababcbacadefegdehijhklij";
        List<Integer> ans = new Solution_763().partitionLabels(s);
        for(Integer num : ans){
            System.out.print(num + " ");
        }
    }
}

/**
 * 划分字母区间
 */
class Solution_763 {
    public List<Integer> partitionLabels(String s) {
        int[] last = new int[26];
        int length = s.length();
        for(int i=0; i<length; i++){
            last[s.charAt(i) - 'a'] = i;
        }
        List<Integer> partition = new ArrayList<>();
        int start = 0, end = 0;
        for(int i=0; i<length; i++){
            end = Math.max(end, last[s.charAt(i) - 'a']);
            if(i == end){
                partition.add(end - start + 1);
                start = end + 1;
            }
        }
        return partition;
    }
}
