package com.style.algorithm.problemset;

import com.style.algorithm.model.TreeNode;

/**
 * 701. 二叉搜索树中的插入操作
 *
 * @author leon
 * @date 2022-01-21 22:38:55
 */
public class Solution701 {
    public TreeNode insertIntoBst(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        } else if (root.val > val) {
            //插入的节点 小于根节点 则应该放到左节点
            root.left =  insertIntoBst(root.left, val);
        } else if (root.val < val) {
            root.right =  insertIntoBst(root.right, val);
        }
        return root;
    }
}
