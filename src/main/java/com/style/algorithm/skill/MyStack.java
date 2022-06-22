package com.style.algorithm.skill;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @author leon
 * @date 2021-12-30 17:43:02
 */
public class MyStack {
    private Queue<Integer> queue;
    private int top = -1;

    public MyStack() {
        queue = new LinkedList<>();
    }

    public void push(int x) {
        queue.add(x);
        top = x;
    }

    public int pop() {
        //栈是后进先出 队列 是先进先出
        int size = queue.size();
        if (size <= 0) {
            return -1;
        }
        //保留队尾两个元素
        while (size > 2) {
            //将元素出栈 在入栈
            queue.offer(queue.poll());
            size--;
        }
        //记录队尾元素
        top = queue.peek();
        //将倒数第二个元素 出栈 在入栈
        queue.offer(queue.poll());
        //将最后一个元素出栈
        return queue.poll();
    }

    public int top() {
        return top;
    }

    public boolean empty() {
        return queue.isEmpty();
    }

    public static void main(String[] args) {
        MyStack myStack = new MyStack();
        myStack.push(1);
        myStack.push(2);
        myStack.push(3);

        int pop = myStack.pop();
        System.out.println("pop: " + pop);

    }

}
