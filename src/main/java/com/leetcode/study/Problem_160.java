package com.leetcode.study;

public class Problem_160 {
    public static void main(String[] args) {
        int[] listA = {4,1,8,4,5};
        int[] listB = {5,0,1,8,4,5};
        ListNode headA = new ListNode(0);
        ListNode headB = new ListNode(0);
        ListNode cur1 = headA;
        ListNode cur2 = headB;
        for(int i=0; i<listA.length; i++){
            ListNode node = new ListNode(listA[i]);
            cur1.next = node;
            cur1 = node;
        }
        for(int i=0; i<listB.length; i++){
            ListNode node = new ListNode(listB[i]);
            cur2.next = node;
            cur2 = node;
        }
        ListNode ans = new Solution_160().getIntersectionNode(headA.next, headB.next);
        System.out.println(ans.val);
    }
}

/**
 * 相交链表
 */
class Solution_160 {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA == null || headB == null) return null;
        ListNode cur1 = headA, cur2 = headB;
        while(cur1 != cur2){
            cur1 = cur1 == null ? headB : cur1.next;
            cur2 = cur2 == null ? headA : cur2.next;
        }
        return cur1;
    }
}












