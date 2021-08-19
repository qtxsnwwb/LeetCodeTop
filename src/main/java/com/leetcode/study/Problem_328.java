package com.leetcode.study;

public class Problem_328 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        ListNode head = new ListNode(0);
        ListNode cur = head;
        for(int i=0; i<nums.length; i++){
            ListNode node = new ListNode(nums[i]);
            cur.next = node;
            cur = node;
        }
        ListNode ans = new Solution_328().oddEvenList(head.next);
        while(ans != null){
            System.out.print(ans.val + " ");
            ans = ans.next;
        }
    }
}

/**
 * 奇偶链表
 *
 *  分离为奇偶链表后合并
 */
class Solution_328 {
    public ListNode oddEvenList(ListNode head) {
        if(head == null) return null;
        ListNode evenHead = head.next;
        ListNode odd = head, even = evenHead;
        while(even != null && even.next != null){
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}
























