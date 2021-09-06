package com.leetcode.study;

public class Problem_344 {
    public static void main(String[] args) {
        char[] s = {'h','e','l','l','o'};
        new Solution_344().reverseString(s);
        for(int i=0; i<s.length; i++){
            System.out.print(s[i] + " ");
        }
    }
}

class Solution_344 {
    public void reverseString(char[] s) {
        int l = 0, r = s.length - 1;
        while(l < r){
            char temp = s[l];
            s[l] = s[r];
            s[r] = temp;
            l++;
            r--;
        }
    }
}
