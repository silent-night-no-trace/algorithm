package com.style.algorithm.skill;

/**
 * @author leon
 * @date 2022-01-05 22:37:52
 */
public class DoubleList {
    /**
     * 头尾虚节点
     */
    private final Node head;
    private final Node tail;
    /**
     * 元素大小
     */
    private int size;

    public DoubleList() {
        //构造头尾节点
        head = new Node(0, 0);
        tail = new Node(0, 0);
        head.next = tail;
        tail.prev = head;
        size = 0;
    }

    /**
     * 列表尾添加
     *
     * @param node node
     */
    public void addLast(Node node) {
        //节点的前一个节点 等于 尾结点的上一个节点
        node.prev = tail.prev;
        //当前节点的下一个 等于 尾结点
        node.next = tail;
        //尾结点上一个元素的 下一个 等于 node
        tail.prev.next = node;
        //尾结点的 上一个节点等于 头节点
        tail.prev = head;
        size++;
    }

    /**
     * head -> node(1,1) --> node(2,2) --> tail
     * <--          <--           <--
     *
     * @param node node
     */
    public void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        size--;
    }

    public Node removeFirst() {
        if (head.next == tail) {
            return null;
        }
        Node first = head.next;
        remove(first);
        size--;
        return first;
    }

    public int size() {
        return size;
    }

    static class Node {
        public int key, val;
        private Node next, prev;

        public Node(int key, int val) {
            this.key = key;
            this.val = val;
        }
    }
}
