package com.leetcode.study;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Problem_148 {
    public static void main(String[] args) {
        int[] nums = {-1,5,3,4,0};
        ListNode head = new ListNode(0);
        ListNode cur = head;
        for(int i=0; i<nums.length; i++){
            ListNode node = new ListNode(nums[i]);
            cur.next = node;
            cur = node;
        }
        ListNode ans = new Solution_148().sortList(head.next);
        while(ans != null){
            System.out.print(ans.val + " ");
            ans = ans.next;
        }
    }
}

/**
 * 排序链表
 *
 * 暴力解决
 */
class Solution_148 {
    public ListNode sortList(ListNode head) {
        if(head == null) return null;
        List<Integer> list = new ArrayList<>();
        while(head != null) {
            list.add(head.val);
            head = head.next;
        }
        int[] arr = new int[list.size()];
        for(int i=0; i<arr.length; i++){
            arr[i] = list.get(i);
        }
        Arrays.sort(arr);
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        for(int i=0; i<arr.length; i++){
            ListNode node = new ListNode(arr[i]);
            cur.next = node;
            cur = node;
        }
        return dummy.next;
    }
}
