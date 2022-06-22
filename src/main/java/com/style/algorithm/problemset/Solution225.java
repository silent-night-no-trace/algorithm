package com.style.algorithm.problemset;

import com.style.algorithm.skill.MyStack;

/**
 * 225. 用队列实现栈
 *
 * @author leon
 * @date 2021-12-30 22:21:14
 */
public class Solution225 {
    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);

        int top = myStack.top();
        System.out.println("top:" + top);
        int pop = myStack.pop();
        System.out.println("pop: " + pop);
    }
}
