package com.leetcode.study;

import java.util.List;

public class Problem_93 {
    public static void main(String[] args) {
        String s = "25525511135";
        List<String> ans = new Solution_93().restoreIpAddresses(s);
        for(String str : ans){
            System.out.print(str + " ");
        }
    }
}

/**
 * 复原 IP 地址
 */
class Solution_93 {

    static final int SEG_COUNT = 4;


    public List<String> restoreIpAddresses(String s) {
        return null;
    }
}
