package com.style.algorithm.problemset;

import com.style.algorithm.model.ListNode;

/**
 * @author leon
 * @date 2021-12-29 23:08:55
 */
public class Solution160 {
    //160. 相交链表
    //给你两个单链表的头节点 headA 和 headB ，请你找出并返回两个单链表相交的起始节点。如果两个链表不存在相交节点，返回 null 。
    //
    //图示两个链表在节点 c1 开始相交：
    //
    //
    //
    //题目数据 保证 整个链式结构中不存在环。
    //
    //注意，函数返回结果后，链表必须 保持其原始结构 。
    //
    //自定义评测：
    //
    //评测系统 的输入如下（你设计的程序 不适用 此输入）：
    //
    //intersectVal - 相交的起始节点的值。如果不存在相交节点，这一值为 0
    //listA - 第一个链表
    //listB - 第二个链表
    //skipA - 在 listA 中（从头节点开始）跳到交叉节点的节点数
    //skipB - 在 listB 中（从头节点开始）跳到交叉节点的节点数
    //评测系统将根据这些输入创建链式数据结构，并将两个头节点 headA 和 headB 传递给你的程序。如果程序能够正确返回相交节点，那么你的解决方案将被 视作正确答案 。

    // 思路 创建p1 p2 分别指向 headA,headB 分别开始遍历 headA遍历结束 去遍历headB headB遍历结束去遍历 headA


    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode p1 = headA, p2 = headB;
        while (p1 != p2) {
            if (p1 == null) {
                p1 = headB;
            } else {
                p1 = p1.next;
            }
            if (p2 == null) {
                p2 = headA;
            } else {
                p2 = p2.next;
            }
        }
        return p1;
    }

    public static void main(String[] args) {
        ListNode listNodeA = new ListNode(1);
        ListNode listNodeB = new ListNode(2);
        ListNode listNodeC = new ListNode(3);
        ListNode listNodeD = new ListNode(4);
        listNodeA.next = listNodeB;
        listNodeB.next = listNodeC;
        listNodeC.next = listNodeD;

        ListNode listNodeA1 = new ListNode(2);
        ListNode listNodeB1 = new ListNode(3);
        ListNode listNodeC1 = new ListNode(5);
        ListNode listNodeD1 = new ListNode(7);
        listNodeA1.next = listNodeC;
        listNodeC.next = listNodeC1;
        listNodeC1.next = listNodeD1;


        ListNode intersectionNode = getIntersectionNode(listNodeA, listNodeA1);
        System.out.println(intersectionNode.val);

    }


}
