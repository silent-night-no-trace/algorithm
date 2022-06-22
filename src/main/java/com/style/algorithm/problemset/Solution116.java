package com.style.algorithm.problemset;

/**
 * 116. 填充每个节点的下一个右侧节点指针
 *
 * @author leon
 * @date 2022-01-16 21:13:52
 */
public class Solution116 {

    public Node connect(Node root) {
        if (null == root) {
            return null;
        }
        connectTwoNode(root.left, root.right);
        return root;
    }

    private void connectTwoNode(Node left, Node right) {
        if (null == left || null == right) {
            return;
        }
        //两个节点连接
        left.next = right;
        // 连接相同⽗节点的两个⼦节点
        connectTwoNode(left.left, left.right);
        connectTwoNode(right.left, right.right);
        // 连接跨越⽗节点的两个⼦节点
        connectTwoNode(left.right, right.left);
    }

    static class Node {
        public int val;
        public Node left;
        public Node right;
        public Node next;
    }
}
