package com.style.algorithm.skill;

import java.util.LinkedList;

/**
 * 单调队列
 *
 * @author leon
 * @date 2022-01-04 17:11:16
 */
public class MonotonicQueue {

    private final LinkedList<Integer> queue = new LinkedList<>();

    public void push(int num) {
        while (!queue.isEmpty() && queue.getLast() < num) {
            queue.pollLast();
        }
        //加入到尾部
        queue.addLast(num);
    }

    public void pop(int num) {
        if (num == queue.getFirst()) {
            queue.pollFirst();
        }
    }

    public int max() {
        return queue.getFirst();
    }

}
