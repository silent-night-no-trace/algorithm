package com.style.algorithm.problemset;

import com.style.algorithm.skill.MyQueue;

/**
 * 232. 用栈实现队列
 *
 * @author leon
 * @date 2021-12-30 22:19:39
 */
public class Solution232 {
    public static void main(String[] args) {
        MyQueue myQueue = new MyQueue();
        myQueue.push(1);
        myQueue.push(2);
        myQueue.push(3);
        int pop = myQueue.pop();
        System.out.println("pop: " + pop);
        int pop1 = myQueue.pop();
        System.out.println("pop1: " + pop1);
        int pop2 = myQueue.pop();
        System.out.println("pop2: " + pop2);
    }
}
