package com.style.algorithm.skill;

/**
 * @author leon
 * @date 2021-07-22 15:31:28
 */
public class RevertLinked {


    private static ListNode revertBetween(ListNode head, Integer m, Integer n) {
        if (m == 1) {
            return revertN(head, n);
        }
        // 前进到反转的起点触发 base case
        head.next = revertBetween(head.next, m - 1, n - 1);
        return head;
    }
    //第一次 revertBetween(HEAD,3,5) 实际传入值 head=1 m=3 n=5
    //第二次调用 head=1 head.next=2 m-1=2  n-1=4 实际传入值 head=2 m=2 n=4
    ///第三次调用 head=2 head.next=3  m-1=1 n-1=3 回到 revertN(3,3)
    //进入 revertN(3,3)  3->4->5->6  反转前3个 返回 5->4->3->6
    //回到第二次 head =2 head.next = 2->5->4->3->6
    //回到第一次 head = 1 head.next = 1->2->5->4->3->6



    private static ListNode successor;

    /**
     * 反转链表前 N 个节点
     *
     * @param head head
     * @param n    n
     * @return ListNode
     */
    private static ListNode revertN(ListNode head, Integer n) {
        if (n == 1) {
            // 记录第 n + 1 个节点
            successor = head.next;
            return head;
        }
        ListNode last = revertN(head.next, n - 1);
        head.next.next = head;
        head.next = successor;
        return last;
    }

    // revertN(HEAD,3)  head = 1  n =3
    // 第二次 head.next =2  n-1=3-1=2
    // 第三次 head.next =3 n-1 = 2-1 = 1    返回 head =3
    // 返回第二次 head =2 2.next.next = head -----> 2->3->4->5->6  ---> 2->3->2  head.next = 3->2->4->5->6
    //第二步重点 2->3->2  2.next = 2->4  但是 3还是->2的 也就变成 3->2->4->5->6
    // 返回第一次 head =1  1.next.next= 1->2->3 ---> 1--->2-->1  head.next= = 1-> 4 = 3->2->1->4->5->6
    //第一步重点 1->2->1  1.next =1->4  但是 2还是->1的 也就变成 3->2->1->4->5->6



    public static ListNode revert(ListNode head) {
        //1 2 3 4 5 6
        System.out.println("传入head:" + head.val);
        if (head.next == null) {
            //
            return head;
        }
        // 6
        ListNode last = revert(head.next);
        System.out.println("last: " + last.val);
        System.out.println("head:" + head.val);
        System.out.println("head next :" + head.next.val);
        head.next.next = head;
        System.out.println("赋值head:" + head.val);
        head.next = null;
        return last;
    }
    // 原有链表 1->2->3->4->5->6
    //第一次 方法进行调用时 1 revert 参数 ->1
    //第二次 2. revert 参数 -> 2
    //第三次 3  revert 参数 -> 3
    //第四次 4. revert 参数 -> 4
    //第五次 5.revert 参数 -> 5
    //第六次 6.revert 参数 ->6 return last  6 方法结束
    //回到第五次 head = 5   head.next.next= 6.next = 5      5->6  6->5  成环
    //下一步操作 head.next = null 5.next = null  即此时链表恢复正常 6->5 返回 last = 6
    //第四次 head = 4  head.next.next= 5.next =4   4->5  5->4  成环
    //下一步操作 head.next = null 4.next =null 返回  上一步操作 链表为 6->5 经过此次操作 5->4  最后此时链表为 6->5->4 返回 last=6
    //第三次 head = 3  head.next.next= 3.next =3   3->4  4->3  成环
    //下一步操作 head.next = null 3.next =null 返回    最后此时链表为 6->5->4->3 返回 last=6
    //第二次 head = 2  head.next.next= 2.next=2   2->3  3->2  成环
    //下一步操作 head.next = null 2.next =null 返回    最后此时链表为 6->5->4->3->2 返回 last=6
    //第一次操作 head =1 head.next.next= 2.next=1 1->2 2->1 成环
    //下一步操作 head.next = null 1.next = null 返回    最后此时链表为 6->5->4->3->2->1 返回 last=6
    //至此操作完成
    //翻转完成


    public ListNode revertList(ListNode head) {
        //当前节点从 头节点开始
        ListNode cur = head;
        ListNode pre = null;
        ListNode tmp;
        while (cur != null) {
            //记录当前节点下一个节点
            tmp = head.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }

    // 输入 1->2->3->4->5->6
    //第一次循环 cur = head = 1   tmp = 2  cur.next = 之前1->2   -----> 1->null  pre = 1  cur = 2
    //第二次循环 tmp = 3 cur.next = 之前 2->3  ----->  2->1  pre = 2 cur= 3
    //3        tmp =4 cur.next = 之前  3->4   ----->  3->2  pre = 3 cur= 4
    // 4       tmp=5 cur.next = 之前 4->5 -----> 4--> 3  pre = 4 cur = 5
    // 5       tmp=6  cur.next = 之前 5->6  -----> 5->4  pre = 5 cur= 6
    //6   tmp = null  cur.next =  之前 6->null ----> 6->5
    //返回


    public ListNode revertWhile(ListNode head) {
        ListNode pre = null, next;
        ListNode cur = head;
        while (cur != null) {
            next = head.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    /**
     * 反转a->b节点
     *
     * @param a a
     * @param b b
     * @return ListNode
     */
    private static ListNode reverse(ListNode a, ListNode b) {
        ListNode cur = a;
        //pre = a
        ListNode pre = null;
        ListNode next;
        while (cur != b) {
            next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    /**
     * k个节点一组翻转链表
     *
     * @param head head
     * @param k    k
     * @return ListNode
     */
    private static ListNode reverseGroup(ListNode head, int k) {
        ListNode b = head;
        for (int i = 0; i < k; i++) {
            if (b == null) {
                return head;
            }
            b = b.next;
        }
        ListNode newHead = reverse(head, b);
        head.next = reverseGroup(b, k);
        return newHead;
    }


    public static void main(String[] args) {

        ListNode head = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);
        ListNode six = new ListNode(6);
        head.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next = six;
        six.next = null;
        ListNode reverse = reverse(head, four);
        System.out.println("reverse:" + reverse.val);
        System.out.println("reverse:" + reverse.next.val);
        System.out.println("reverse:" + reverse.next.next.val);
        System.out.println("reverse:" + reverse.next.next.next.val);

        //revert(HEAD);
//        revertN(HEAD,3);
//        revertBetween(HEAD, 3, 5);
//        System.out.println(revert.val);
//        System.out.println(revert.next.val);
//        System.out.println(revert.next.next.val);
//        System.out.println(revert.next.next.next.val);
//        System.out.println(revert.next.next.next.next.val);
//        System.out.println(revert.next.next.next.next.next.val);
//        System.out.println(revert.next.next.next.next.next.next);

//        System.out.println(revert(head));
//        System.out.println(revertN(head,3));

    }


    /**
     * 定义链表节点
     */
    static class ListNode {
        ListNode next;
        int val;

        ListNode(int x) {
            this.val = x;
        }
    }

    private static final ListNode HEAD;

    static {
        HEAD = new ListNode(1);
        ListNode two = new ListNode(2);
        ListNode three = new ListNode(3);
        ListNode four = new ListNode(4);
        ListNode five = new ListNode(5);
        ListNode six = new ListNode(6);
        HEAD.next = two;
        two.next = three;
        three.next = four;
        four.next = five;
        five.next = six;
        six.next = null;
    }

}
