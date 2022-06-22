package com.style.algorithm.model;

import lombok.ToString;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 树节点
 *
 * @author leon
 * @date 2021-11-20 23:18:38
 */
@ToString
public class TreeNode {
    public Integer val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(Integer val) {
        this.val = val;
        this.left = null;
        this.right = null;
    }

    public static void main(String[] args) {
        TreeNode treeNode = new TreeNode(3);
        TreeNode left = new TreeNode(5);
        TreeNode right = new TreeNode(8);
        treeNode.left = left;
        treeNode.right = right;
        System.out.println("treeNode: " + treeNode);
        Integer integer = levelTraverse(treeNode);
        System.out.println(integer);

    }


    /**
     * ⼆叉树遍历框架，典型的⾮线性递归遍历结构：
     *
     * @param treeNode treeNode
     */
    public void traverse(TreeNode treeNode) {
        traverse(treeNode.left);
        traverse(treeNode.right);
    }

    /**
     * 层级遍历
     *
     * @param treeNode treeNode
     * @return Integer
     */
    public static Integer levelTraverse(TreeNode treeNode) {
        if (null == treeNode) {
            return 0;
        }
        Integer depth = 1;
        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        treeNodeQueue.offer(treeNode);

        while (!treeNodeQueue.isEmpty()) {
            int size = treeNodeQueue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = treeNodeQueue.poll();
                TreeNode left = poll.left;
                if (null != left) {
                    treeNodeQueue.offer(left);
                }
                TreeNode right = poll.right;
                if (null != right) {
                    treeNodeQueue.offer(right);
                }
            }
            depth++;
        }
        return depth;
    }
}
