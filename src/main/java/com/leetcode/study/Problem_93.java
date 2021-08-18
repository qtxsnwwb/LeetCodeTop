package com.leetcode.study;

import java.util.ArrayList;
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
    List<String> ans = new ArrayList<>();
    int[] segments = new int[SEG_COUNT];

    public List<String> restoreIpAddresses(String s) {
        segments = new int[SEG_COUNT];
        dfs(s, 0, 0);
        return ans;
    }

    private void dfs(String s, int segId, int segStart) {
        //如果找到了4段IP地址并且遍历完了字符串，那么就是一种答案
        if(segId == SEG_COUNT){
            if(segStart == s.length()){
                StringBuffer ipAddr = new StringBuffer();
                for(int i=0; i<SEG_COUNT; i++){
                    ipAddr.append(segments[i]);
                    if(i != SEG_COUNT - 1){
                        ipAddr.append('.');
                    }
                }
                ans.add(ipAddr.toString());
            }
            return;
        }
        //如果还没有找到4段IP地址就已经便利完了字符串，那么提前回溯
        if(segStart == s.length()) return;

        //由于不能有前导0，如果当前数字为0，那么这一段IP地址只能为0
        if(s.charAt(segStart) == '0'){
            segments[segId] = 0;
            dfs(s, segId+1, segStart+1);
        }

        //一般情况，枚举每一种可能性并递归
        int addr = 0;
        for(int segEnd = segStart; segEnd < s.length(); segEnd++){
            addr = addr * 10 + (s.charAt(segEnd) - '0');
            if(addr > 0 && addr <= 0xFF){
                segments[segId] = addr;
                dfs(s, segId+1, segEnd+1);
            }else{
                break;
            }
        }
    }
}
