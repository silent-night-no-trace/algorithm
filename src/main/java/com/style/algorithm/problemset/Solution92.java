package com.style.algorithm.problemset;

import com.style.algorithm.model.ListNode;

/**
 * 92. 反转链表 II
 *
 * @author leon
 * @date 2021-12-30 16:33:38
 */
@SuppressWarnings("all")
public class Solution92 {

    //给你单链表的头指针 head 和两个整数 left 和 right ，其中 left <= right 。请你反转从位置 left 到位置 right 的链表节点，返回 反转后的链表 。
    //
    //
    //示例 1：
    //
    //
    //输入：head = [1,2,3,4,5], left = 2, right = 4
    //输出：[1,4,3,2,5]
    //示例 2：
    //
    //输入：head = [5], left = 1, right = 1
    //输出：[5]
    //
    //
    //提示：
    //
    //链表中节点数目为 n
    //1 <= n <= 500
    //-500 <= Node.val <= 500
    //1 <= left <= right <= n
    //
    //
    //进阶： 你可以使用一趟扫描完成反转吗？

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if (null == head) {
            return null;
        }
        if (left == 1) {
            //反转链表前N个
            return revertN(head, right);
        }
        head.next = reverseBetween(head.next, left - 1, right - 1);
        return head;
    }

    /**
     * 后驱节点
     */
    private static ListNode successor;

    private static ListNode revertN(ListNode head, int k) {
        if (k == 1) {
            successor = head.next;
            return head;
        }
        ListNode last = revertN(head.next, k - 1);
        head.next.next = head;
        head.next = successor;
        return last;
    }

}
