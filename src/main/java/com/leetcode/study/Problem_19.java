package com.leetcode.study;

public class Problem_19 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        ListNode head = new ListNode(0);
        ListNode cur = head;
        for(int i=0; i<nums.length; i++){
            ListNode node = new ListNode(nums[i]);
            cur.next = node;
            cur = node;
        }
        int n = 2;
        ListNode ans = new Solution_19().removeNthFromEnd(head.next, n);
        while(ans != null){
            System.out.print(ans.val + " ");
            ans = ans.next;
        }
    }
}

/**
 * 删除链表的倒数第 N 个结点
 */
class Solution_19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode left = dummy, right = head;
        while(n != 0){
            right = right.next;
            n--;
            if(n != 0 && right == null) return head;
        }
        while(right != null){
            left = left.next;
            right = right.next;
        }
        left.next = left.next.next;
        return dummy.next;
    }
}
