package com.style.algorithm.problemset;

import com.style.algorithm.model.ListNode;

/**
 * 142 环形链表 II
 *
 * @author leon
 * @date 2021-12-29 22:49:15
 */
public class Solution142 {
    //142. 环形链表 II
    //给定一个链表，返回链表开始入环的第一个节点。 如果链表无环，则返回 null。
    //
    //如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。 为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。如果 pos 是 -1，则在该链表中没有环。注意：pos 不作为参数进行传递，仅仅是为了标识链表的实际情况。
    //
    //不允许修改 链表。
    //
    //
    //
    //示例 1：
    //
    //
    //
    //输入：head = [3,2,0,-4], pos = 1
    //输出：返回索引为 1 的链表节点
    //解释：链表中有一个环，其尾部连接到第二个节点。
    //示例 2：
    //
    //
    //
    //输入：head = [1,2], pos = 0
    //输出：返回索引为 0 的链表节点
    //解释：链表中有一个环，其尾部连接到第一个节点。
    //示例 3：
    //
    //
    //
    //输入：head = [1], pos = -1
    //输出：返回 null
    //解释：链表中没有环。
    //
    //
    //提示：
    //
    //链表中节点的数目范围在范围 [0, 104] 内
    //-105 <= Node.val <= 105
    //pos 的值为 -1 或者链表中的一个有效索引
    //
    //
    //进阶：你是否可以使用 O(1) 空间解决此题？'

    public ListNode detectCycle(ListNode head) {

        ListNode slow = head, fast = head;
        while (fast != null && null != fast.next) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                //快慢指针相同 遇到了环
                break;
            }
        }
        //快指针或者 快指针下一个为null 说明不存在环节点
        if (fast == null || fast.next == null) {
            return null;
        }

        //将慢指针置位头节点
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;
    }

    //我们假设快慢指针相遇时，慢指针 slow ⾛了 k 步，那么快指针 fast ⼀定⾛了 2k 步：
    //fast ⼀定⽐ slow 多⾛了 k 步，这多⾛的 k 步其实就是 fast 指针在环⾥转圈圈，所以 k 的值就是环⻓度 的「整数倍」。 假设相遇点距环的起点的距离为 m，那么结合上图的 slow 指针，环的起点距头结点 head 的距离为 k -
    //m，也就是说如果从 head 前进 k - m 步就能到达环起点。 巧的是，如果从相遇点继续前进 k - m 步，也恰好到达环起点。因为结合上图的 fast 指针，从相遇点开始 ⾛k步可以转回到相遇点，那⾛ k - m 步肯定就⾛到环起点了：
}
