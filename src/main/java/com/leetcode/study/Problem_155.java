package com.leetcode.study;

import java.util.Stack;

public class Problem_155 {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.top());
        System.out.println(minStack.getMin());
    }
}

/**
 * 最小栈
 *
 * 解题：
 *      辅助栈，其栈顶存储当前最小元素，与元素栈一同插入弹出
 */
class MinStack {

    Stack<Integer> stack1;    //元素栈
    Stack<Integer> stack2;    //辅助栈

    /** initialize your data structure here. */
    public MinStack() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
        stack2.push(Integer.MAX_VALUE);
    }

    public void push(int val) {
        stack1.push(val);
        stack2.push(Math.min(stack2.peek(), val));
    }

    public void pop() {
        stack1.pop();
        stack2.pop();
    }

    public int top() {
        return stack1.peek();
    }

    public int getMin() {
        return stack2.peek();
    }
}