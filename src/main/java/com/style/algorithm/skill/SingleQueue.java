package com.style.algorithm.skill;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * @author leon
 * @date 2021-07-22 14:44:20
 */
public class SingleQueue {
    private final Deque<Integer> deque = new ArrayDeque<>();

    public void push(Integer data) {
        while (!deque.isEmpty() && deque.getLast() < data) {
            deque.remove(deque.getLast());
        }
        deque.addFirst(data);
    }

    public Integer max() {
        return deque.getFirst();
    }

    public void pop(Integer data) {
        if (!deque.isEmpty() && deque.getFirst().equals(data)) {
            deque.removeFirst();
        }
    }

    public static void main(String[] args) {
        SingleQueue singleQueue = new SingleQueue();
        singleQueue.push(1);
        System.out.println("max:" + singleQueue.max());
        singleQueue.push(2);
        System.out.println("max:" + singleQueue.max());
        singleQueue.push(3);
        System.out.println("max:" + singleQueue.max());
        singleQueue.push(5);
        System.out.println("max:" + singleQueue.max());
    }

}
