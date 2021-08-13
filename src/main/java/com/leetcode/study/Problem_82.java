package com.leetcode.study;

public class Problem_82 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,3,4,4,5};
        ListNode head = new ListNode(0);
        ListNode cur = head;
        for(int i=0; i<nums.length; i++){
            ListNode node = new ListNode(nums[i]);
            cur.next = node;
            cur = node;
        }
        ListNode ans = new Solution_82().deleteDuplicates(head.next);
        while(ans != null){
            System.out.print(ans.val + " ");
            ans = ans.next;
        }
    }
}

/**
 * 删除排序链表中的重复元素 2
 */
class Solution_82 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return null;
        ListNode dummy = new ListNode(0, head);
        ListNode cur = dummy;
        while(cur.next != null && cur.next.next != null){
            if(cur.next.val == cur.next.next.val){
                int x = cur.next.val;
                while(cur.next != null && cur.next.val == x){
                    cur.next = cur.next.next;
                }
            }else{
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}