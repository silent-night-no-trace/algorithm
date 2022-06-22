package com.style.algorithm.problemset;

import com.style.algorithm.model.ListNode;

import java.util.PriorityQueue;

/**
 * @author leon
 * @date 2021-12-29 17:07:30
 */
@SuppressWarnings("all")
public class Solution23 {

    public ListNode mergeKLists(ListNode[] lists) {
        if (null == lists || 0 == lists.length) {
            return null;
        }
        int length = lists.length;
        //创建升序优先级队列
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>(length, (a, b) -> (a.val - b.val));
        //将头结点存入优先级队列
        for (ListNode listNode : lists) {
            if (null != listNode) {
                priorityQueue.add(listNode);
            }
        }
        //创建虚拟节点
        ListNode dummy = new ListNode(-1), p = dummy;
        while (!priorityQueue.isEmpty()) {
            ListNode poll = priorityQueue.poll();
            p.next = poll;
            if (poll.next != null) {
                priorityQueue.add(poll.next);
            }
            p = p.next;
        }

        return dummy.next;
    }
}
