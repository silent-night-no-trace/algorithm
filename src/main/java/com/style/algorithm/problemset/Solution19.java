package com.style.algorithm.problemset;

import com.style.algorithm.model.ListNode;

/**
 * 19. 删除链表的倒数第 N 个结点
 *
 * @author leon
 * @date 2021-12-29 21:48:27
 */
public class Solution19 {
    //给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
    //
    
    //
    //示例 1：
    //
    //
    //输入：head = [1,2,3,4,5], n = 2
    //输出：[1,2,3,5]
    //示例 2：
    //
    //输入：head = [1], n = 1
    //输出：[]
    //示例 3：
    //
    //输入：head = [1,2], n = 1
    //输出：[1]
    
    //
    //提示：
    //
    //链表中结点的数目为 sz
    //1 <= sz <= 30
    //0 <= Node.val <= 100
    //1 <= n <= sz
    //进阶：你能尝试使用一趟扫描实现吗？
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/remove-nth-node-from-end-of-list

    public ListNode removeNthFromEnd(ListNode head, int n) {
        if (null == head) {
            return null;
        }
        //构建虚拟节点
        //不过注意我们⼜使⽤了虚拟头结点的技巧，也是为了防⽌出现空指针的情况
        // ，⽐如说链表总共有 5 个节点， 题⽬就让你删除倒数第 5 个节点，也就是第⼀个节点
        // ，那按照算法逻辑，应该⾸先找到倒数第 6 个节点。但 第⼀个节点前⾯已经没有节点了，
        // 这就会出错。 但有了我们虚拟节点 dummy 的存在，就避免了这个问题，能够对这种情况进⾏正确的删除。
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode fromEnd = findFromEnd(dummy, n + 1);
        fromEnd.next = fromEnd.next.next;
        return dummy.next;
    }

    public ListNode findFromEnd(ListNode listNode, int n) {
        if (null == listNode) {
            return null;
        }
        ListNode p1 = listNode;
        for (int i = 0; i < n; i++) {
            p1 = p1.next;
        }

        ListNode p2 = listNode;
        while (p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        return p2;
    }
}
