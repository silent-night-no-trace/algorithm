package com.style.algorithm.problemset;

import com.style.algorithm.model.TreeNode;

/**
 * 226. 翻转二叉树
 *
 * @author leon
 * @date 2022-01-16 21:07:34
 */
public class Solution226 {

    public TreeNode invertTree(TreeNode root) {
        //// base case
        if (null == root) {
            return null;
        }
        // 前序遍历位置
        // root 节点需要交换它的左右⼦节点
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        // 让左右⼦节点继续翻转它们的⼦节点
        invertTree(root.left);
        invertTree(root.right);
        return root;
    }
}
