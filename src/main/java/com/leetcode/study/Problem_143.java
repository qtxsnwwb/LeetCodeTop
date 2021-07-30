package com.leetcode.study;

import java.util.ArrayList;
import java.util.List;

public class Problem_143 {
    public static void main(String[] args) {
        int[] nums = {1,2,3,4,5};
        ListNode head = new ListNode(-1);
        ListNode cur = head;
        for(int i=0; i<nums.length; i++){
            ListNode node = new ListNode(nums[i]);
            cur.next = node;
            cur = node;
        }
        new Solution_143().reorderList(head.next);
        ListNode node = head.next;
        while(node != null){
            System.out.print(node.val + " ");
            node = node.next;
        }
    }
}

/**
 * 重排链表
 *
 * 暴力解决
 */
class Solution_143{
    public void reorderList(ListNode head) {
        if(head == null) return;
        List<ListNode> list = new ArrayList<>();
        ListNode node = head;
        while(node != null){
            list.add(node);
            node = node.next;
        }
        int l = 0, r = list.size()-1;
        while(l < r){
            list.get(l++).next = list.get(r);
            if(l == r) break;
            list.get(r--).next = list.get(l);
        }
        list.get(l).next = null;
    }
}
