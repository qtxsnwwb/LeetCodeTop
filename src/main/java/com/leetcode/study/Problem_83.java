package com.leetcode.study;

public class Problem_83 {
    public static void main(String[] args) {
        int[] nums = {1,1,2,3,3};
        ListNode head = new ListNode(0);
        ListNode cur = head;
        for(int i=0; i<nums.length; i++){
            ListNode node = new ListNode(nums[i]);
            cur.next = node;
            cur = node;
        }
        ListNode ans = new Solution_83().deleteDuplicates(head.next);
        while(ans != null){
            System.out.print(ans.val + " ");
            ans = ans.next;
        }
    }
}

/**
 * 删除排序链表中的重复元素
 */
class Solution_83 {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return null;
        ListNode pre = null;
        ListNode cur = head;
        while(cur != null){
            if(pre != null && pre.val == cur.val){
                pre.next = cur.next;
            }else{
                pre = cur;
            }
            cur = cur.next;
        }
        return head;
    }
}
