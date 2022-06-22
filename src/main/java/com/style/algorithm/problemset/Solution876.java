package com.style.algorithm.problemset;

import com.style.algorithm.model.ListNode;

/**
 * 876. 链表的中间结点
 *
 * @author leon
 * @date 2021-12-29 22:24:05
 */
public class Solution876 {

    //给定一个头结点为 head 的非空单链表，返回链表的中间结点。
    //
    //如果有两个中间结点，则返回第二个中间结点。


    public ListNode middleNode(ListNode head) {
        if (null == head) {
            return null;
        }
        //使用快慢指针
        ListNode slow = head, fast = head;
        //快指针到 末尾结束 这时候慢指针到了中间
        while (fast != null && fast.next != null) {
            //快指针两步 慢指针一步
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
    }
}
