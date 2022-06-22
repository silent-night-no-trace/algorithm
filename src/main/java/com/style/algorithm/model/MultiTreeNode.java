package com.style.algorithm.model;

/**
 * 多叉树
 *
 * @author leon
 * @date 2021-12-18 11:21:12
 */
public class MultiTreeNode {
    public Integer val;
    public MultiTreeNode[] children;

    public void traverse(MultiTreeNode multiTreeNode) {
        for (MultiTreeNode node : multiTreeNode.children) {
            traverse(node);
        }
    }

}
