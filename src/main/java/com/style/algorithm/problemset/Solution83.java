package com.style.algorithm.problemset;

import com.style.algorithm.model.ListNode;

/**
 * 83 有序链表，去重
 *
 * @author leon
 * @date 2021-12-29 10:27:37
 */
public class Solution83 {
    public static ListNode deleteDuplicates(ListNode head) {
        if (null == head) {
            return null;
        }
        if (null == head.next) {
            return head;
        }
        ListNode slow = head, fast = head;
        while (fast != null) {
            if (!fast.val.equals(slow.val)) {
                //nums[slow] = nums[fast]
                slow.next = fast;
                //slow++;
                slow = slow.next;
            }
            fast = fast.next;
        }
        //断开slow后面的连接
        slow.next = null;
        return head;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode one = new ListNode(1);
        ListNode two = new ListNode(2);
        head.next = one;
        one.next = two;
        ListNode listNode = deleteDuplicates(head);

    }
}
