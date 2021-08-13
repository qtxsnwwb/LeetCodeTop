package com.leetcode.study;

public class Problem_21 {
    public static void main(String[] args) {
        int[] num1 = {1,2,4};
        int[] num2 = {1,3,4};
        ListNode l1 = new ListNode(0);
        ListNode l2 = new ListNode(0);
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        for(int i=0; i<num1.length; i++){
            ListNode node = new ListNode(num1[i]);
            cur1.next = node;
            cur1 = node;
        }
        for(int i=0; i<num2.length; i++){
            ListNode node = new ListNode(num2[i]);
            cur2.next = node;
            cur2 = node;
        }
        ListNode ans = new Solution_21().mergeTwoLists(l1.next, l2.next);
        while(ans != null){
            System.out.print(ans.val + " ");
            ans = ans.next;
        }
    }
}

/**
 * 合并两个有序链表
 */
class Solution_21 {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null) return null;
        if(l1 == null) return l2;
        if(l2 == null) return l1;
        ListNode head = new ListNode(0);
        ListNode cur = head;
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        while(cur1 != null && cur2 != null){
            if(cur1.val <= cur2.val){
                cur.next = cur1;
                cur = cur1;
                cur1 = cur1.next;
            }else{
                cur.next = cur2;
                cur = cur2;
                cur2 = cur2.next;
            }
        }
        cur.next = cur1 == null ? cur2 : cur1;
        return head.next;
    }
}


















