package com.leetcode.study;

import java.util.HashMap;
import java.util.Map;

public class Problem_3 {
    public static void main(String[] args) {
        String s = "abcabcbb";
        System.out.println(new Solution_3().lengthOfLongestSubstring(s));
    }
}

/**
 * 无重复字符的最长子串
 */
class Solution_3 {
    public int lengthOfLongestSubstring(String s) {
        int n = s.length(), ans = 0;
        Map<Character, Integer> map = new HashMap<>();
        for(int end=0, start=0; end<n; end++){
            char alpha = s.charAt(end);
            if(map.containsKey(alpha)){
                start = Math.max(map.get(alpha), start);
            }
            ans = Math.max(ans, end - start + 1);
            map.put(s.charAt(end), end + 1);
        }
        return ans;
    }
}


























