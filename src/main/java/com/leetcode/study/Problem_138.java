package com.leetcode.study;

import java.util.HashMap;
import java.util.Map;

public class Problem_138 {
    public static void main(String[] args) {
        Node node1 = new Node(7);
        Node node2 = new Node(13);
        Node node3 = new Node(11);
        Node node4 = new Node(10);
        Node node5 = new Node(1);
        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node1.random = null;
        node2.random = node1;
        node3.random = node5;
        node4.random = node3;
        node5.random = node1;
        new Solution_138().copyRandomList(node1);
    }
}

/**
 * 复制带随机指针的链表
 */
class Solution_138 {

    Map<Node, Node> cachedNode = new HashMap<>();

    public Node copyRandomList(Node head) {
        if(head == null) return null;
        if(!cachedNode.containsKey(head)){
            Node headNew = new Node(head.val);
            cachedNode.put(head, headNew);
            headNew.next = copyRandomList(head.next);
            headNew.random = copyRandomList(head.random);
        }
        return cachedNode.get(head);
    }
}
