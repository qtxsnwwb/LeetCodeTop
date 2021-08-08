package com.leetcode.study;

public class Problem_142 {
    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(-4);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node1;
        ListNode ans = new Solution_142().detectCycle(head);
        System.out.println(ans.val);
    }
}

/**
 * 环形链表2
 */
class Solution_142 {
    public ListNode detectCycle(ListNode head) {
        if(head == null) return null;
        ListNode fast = head, slow = head;
        do{
            if(fast.next == null || fast.next.next == null) return null;
            fast = fast.next.next;
            slow = slow.next;
        }while(fast != slow);
        fast = head;
        while(fast != slow){
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }
}
