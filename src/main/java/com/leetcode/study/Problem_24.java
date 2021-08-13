package com.leetcode.study;

public class Problem_24 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4};
        ListNode head = new ListNode(0);
        ListNode cur = head;
        for(int i=0; i<nums.length; i++){
            ListNode node = new ListNode(nums[i]);
            cur.next = node;
            cur = node;
        }
        ListNode ans = new Solution_24().swapPairs(head.next);
        while(ans != null){
            System.out.print(ans.val + " ");
            ans = ans.next;
        }
    }
}

/**
 * 两两交换链表中的节点
 */
class Solution_24 {
    public ListNode swapPairs(ListNode head) {
        if(head == null) return null;
        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;
        pre.next = head;
        ListNode cur = head;
        while(cur != null){
            cur = cur.next;
            if(cur != null){
                ListNode next = cur.next;
                ListNode start = pre.next;
                pre.next = cur;
                cur.next = start;
                start.next = next;
                pre = start;
                cur = next;
            }
        }
        return dummy.next;
    }
}
