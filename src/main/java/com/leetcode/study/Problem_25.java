package com.leetcode.study;

public class Problem_25 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        int k = 2;
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        for(int i=0; i<nums.length; i++){
            ListNode node = new ListNode(nums[i]);
            cur.next = node;
            cur = cur.next;
        }
        ListNode ans = new Solution_25().reverseKGroup(head.next, k);
        while(ans != null) {
            System.out.print(ans.val + " ");
            ans = ans.next;
        }
    }
}

/**
 * K个一组翻转链表
 */
class Solution_25 {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode pre = dummy;    //翻转部分前一个节点
        ListNode end = dummy;    //翻转部分最后一个节点

        while(end.next != null){
            //移动end到指定数量k
            for(int i=0; i<k && end!=null; i++) end = end.next;
            //若剩余节点数量不足数量k，结束循环
            if(end == null) break;

            ListNode start = pre.next;     //翻转部分第一个节点
            ListNode next = end.next;      //翻转部分后一个节点
            end.next = null;       //截断翻转部分
            pre.next = reverse(start);     //翻转
            start.next = next;     //翻转后start变为翻转部分尾结点，指向翻转前翻转部分后一个节点
            //调整pre和end，开启下一轮翻转
            pre = start;
            end = pre;
        }
        return dummy.next;
    }

    private ListNode reverse(ListNode head){
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


















