package com.leetcode.study;

public class Problem_141 {
    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        ListNode node1 = new ListNode(2);
        ListNode node2 = new ListNode(0);
        ListNode node3 = new ListNode(-4);
        head.next = node1;
        node1.next = node2;
        node2.next = node3;
        node3.next = node1;
        System.out.println(new Solution_141().hasCycle(head));
    }
}

/**
 * 环形链表
 *
 * 快慢指针
 *      快指针一次走两格，慢指针一次走一格，如果最终二者能相遇说明有环
 */
class Solution_141 {
    //官方解答
//    public boolean hasCycle(ListNode head) {
//        if(head == null || head.next == null){
//            return false;
//        }
//        ListNode fast = head.next, slow = head;
//        while(slow != fast){
//            if(fast == null || fast.next == null){
//                return false;
//            }
//            slow = slow.next;
//            fast = fast.next.next;
//        }
//        return true;
//    }

    //我的答案
    public boolean hasCycle(ListNode head) {
        if(head == null || head.next == null){
            return false;
        }
        ListNode fast = head, slow = head;
        do{
            slow = slow.next;
            fast = fast.next.next;
            if(fast == null || fast.next == null){
                return false;
            }
        }while(slow != fast);
        return true;
    }
}
