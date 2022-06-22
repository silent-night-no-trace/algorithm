package com.style.algorithm.problemset;

import com.style.algorithm.model.ListNode;

import java.util.PriorityQueue;

/**
 * @author leon
 * @date 2021-12-29 14:25:21
 */
@SuppressWarnings("all")
public class Solution21 {
    /**
     * Definition for singly-linked list.
     * public class ListNode {
     * int val;
     * ListNode next;
     * ListNode() {}
     * ListNode(int val) { this.val = val; }
     * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        //构建虚拟节点
        ListNode dummy = new ListNode(-1), p = dummy;
        ListNode p1 = list1, p2 = list2;
        while (null != p1 && null != p2) {
            if (p1.val > p2.val) {
                p.next = p2;
                p2 = p2.next;
            } else {
                p.next = p1;
                p1 = p1.next;
            }
            p = p.next;
        }

        if (p1 != null) {
            p.next = p1;
        }

        if (null != p2) {
            p.next = p2;
        }

        return dummy.next;
    }

    public static ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
        PriorityQueue<ListNode> priorityQueue = new PriorityQueue<>((a, b) -> (a.val - b.val));
        if (null != list1) {
            priorityQueue.add(list1);
        }
        if (null != list2) {
            priorityQueue.add(list2);
        }
        //构建虚拟节点
        ListNode dummy = new ListNode(-1), p = dummy;
        while (!priorityQueue.isEmpty()) {
            ListNode poll = priorityQueue.poll();
            p.next = poll;
            if (null != poll.next) {
                priorityQueue.add(poll.next);
            }
            p = p.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode11 = new ListNode(2);
        ListNode listNode12 = new ListNode(3);
        listNode1.next = listNode11;
        listNode11.next = listNode12;

        ListNode listNode2 = new ListNode(1);
        ListNode listNode21 = new ListNode(3);
        ListNode listNode22 = new ListNode(4);
        listNode2.next = listNode21;
        listNode21.next = listNode22;

        //ListNode listNode = mergeTwoLists(listNode1, listNode2);
        ListNode listNode = mergeTwoLists2(listNode1, listNode2);
        for (ListNode p = listNode; p != null; p = p.next) {
            System.out.println(p.val);
        }
        System.out.println("===========================");
        //ListNode res = mergeTwoLists(null, listNode2);

//        for (ListNode p = res; p != null; p = p.next) {
//            System.out.println(p.val);
//        }

    }
}
