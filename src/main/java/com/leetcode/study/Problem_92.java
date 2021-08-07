package com.leetcode.study;

public class Problem_92 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        int left = 2, right = 4;
        ListNode head = new ListNode(0);
        ListNode cur = head;
        for(int i=0; i<nums.length; i++){
            ListNode node = new ListNode(nums[i]);
            cur.next = node;
            cur = node;
        }
        ListNode ans = new Solution_92().reverseBetween(head.next, left, right);
        while(ans != null){
            System.out.print(ans.val + " ");
            ans = ans.next;
        }
    }
}

/**
 * 反转链表2
 */
class Solution_92 {
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(0);
        ListNode start = head, end = head;
        ListNode pre = dummy;
        pre.next = head;
        while(left != 1){
            start = start.next;
            end = end.next;
            pre = pre.next;
            left--;
            right--;
        }
        while(right != 1){
            end = end.next;
            right--;
        }
        ListNode next = end.next;
        end.next = null;
        pre.next = reverse(pre.next);
        start.next = next;
        return dummy.next;
    }

    private ListNode reverse(ListNode head) {
        ListNode pre = null;
        ListNode cur = head;
        while(cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }
}
















