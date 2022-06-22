package com.style.algorithm.problemset;

import com.style.algorithm.model.ListNode;

/**
 * 141. 环形链表
 *
 * @author leon
 * @date 2021-12-29 22:38:39
 */
public class Solution141 {
    public boolean hasCycle(ListNode head) {
        if (null == head) {
            return false;
        }
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }

        return false;
    }
}
