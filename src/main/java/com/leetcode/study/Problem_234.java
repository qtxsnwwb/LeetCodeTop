package com.leetcode.study;

import java.util.ArrayList;
import java.util.List;

public class Problem_234 {
    public static void main(String[] args) {
        int[] nums = {1,2,2,1};
        ListNode head = new ListNode(0);
        ListNode cur = head;
        for(int i=0; i<nums.length; i++){
            ListNode node = new ListNode(nums[i]);
            cur.next = node;
            cur = node;
        }
        System.out.println(new Solution_234().isPalindrome(head.next));
    }
}

/**
 * 回文链表
 */
class Solution_234 {
    public boolean isPalindrome(ListNode head) {
        if(head == null) return true;
        List<ListNode> list = new ArrayList<>();
        while(head != null){
            list.add(head);
            head = head.next;
        }
        int l = 0, r = list.size()-1;
        while(l < r){
            if(list.get(l++).val != list.get(r--).val) return false;
        }
        return true;
    }
}
