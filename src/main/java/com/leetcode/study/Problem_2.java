package com.leetcode.study;

public class Problem_2 {
    public static void main(String[] args) {
        int[] nums1 = {2,4,3};
        int[] nums2 = {5,6,4};
        ListNode l1 = new ListNode(0);
        ListNode l2 = new ListNode(0);
        ListNode cur1 = l1;
        ListNode cur2 = l2;
        for(int i=0; i<nums1.length; i++){
            ListNode node = new ListNode(nums1[i]);
            cur1.next = node;
            cur1 = node;
        }
        for(int i=0; i<nums2.length; i++){
            ListNode node = new ListNode(nums2[i]);
            cur2.next = node;
            cur2 = node;
        }
        ListNode ans = new Solution_2().addTwoNumbers(l1.next, l2.next);
        while(ans != null){
            System.out.print(ans.val + " ");
            ans = ans.next;
        }
    }
}

/**
 * 两数相加
 */
class Solution_2 {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if(l1 == null && l2 == null) return null;
        if(l1 == null || l2 == null) return l1 == null ? l2 : l1;
        int carry = 0;
        ListNode ans = new ListNode(0);
        ListNode cur = ans;
        while(l1 != null || l2 != null){
            int num1 = l1 == null ? 0 : l1.val;
            int num2 = l2 == null ? 0 : l2.val;
            int result = num1 + num2 + carry;
            carry = result / 10;
            result %= 10;
            ListNode node = new ListNode(result);
            cur.next = node;
            cur = node;
            l1 = l1 == null ? l1 : l1.next;
            l2 = l2 == null ? l2 : l2.next;
        }
        if(carry != 0){
            ListNode node = new ListNode(1);
            cur.next = node;
        }
        return ans.next;
    }
}
