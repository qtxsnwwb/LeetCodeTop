package com.leetcode.study;

public class Problem_61 {
    public static void main(String[] args) {
        int[] nums = {0,1,2};
        int k = 4;
        ListNode head = new ListNode(0);
        ListNode cur = head;
        for(int i=0; i<nums.length; i++){
            ListNode node = new ListNode(nums[i]);
            cur.next = node;
            cur = node;
        }
        ListNode ans = new Solution_61().rotateRight(head.next, k);
        while(ans != null){
            System.out.print(ans.val + " ");
            ans = ans.next;
        }
    }
}

/**
 * 旋转链表
 */
class Solution_61 {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || k == 0 || head.next == null) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode left = dummy;
        ListNode right = dummy;
        while(k != 0){
            right = right.next;
            if(right == null) right = head;
            k--;
        }
        //单独谈论链表长度等于k的情况
        if(right.next == null){
            return head;
        }
        while(right.next != null){
            right = right.next;
            left = left.next;
        }
        ListNode next = left.next;
        right.next = head;
        left.next = null;
        return next;
    }
}




























