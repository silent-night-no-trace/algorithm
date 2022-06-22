package com.style.algorithm.model;

/**
 * 单列表节点
 *
 * @author leon
 * @date 2021-11-20 23:24:51
 */
public class ListNode {
    public Integer val;
    public ListNode next;

    public ListNode(Integer val) {
        this.val = val;
        this.next = null;
    }

    public static void main(String[] args) {
        ListNode listNode = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        listNode.next = two;
        two.next = three;
        System.out.println("listNode: " + listNode);
    }


    /**
     * 线性遍历
     *
     * @param listNode listNode
     */
    public void traverse(ListNode listNode) {
        for (ListNode p = listNode; p != null; p = p.next) {
            System.out.println(p.val);
        }
    }

    /**
     * 递归方式
     *
     * @param listNode listNode
     */
    public void traverseRecursion(ListNode listNode) {
        System.out.println(listNode.val);
        traverse(listNode.next);
    }
}
