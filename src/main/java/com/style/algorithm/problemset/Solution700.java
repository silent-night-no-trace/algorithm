package com.style.algorithm.problemset;

import com.style.algorithm.model.TreeNode;

/**
 * 700. 二叉搜索树中的搜索
 *
 * @author leon
 * @date 2022-01-21 22:31:13
 */
@SuppressWarnings("all")
public class Solution700 {

    public TreeNode searchBst(TreeNode root, int val) {
        if (null == root) {
            return null;
        }
        if (root.val > val) {
            //根节点 大于 搜索值 直接去 做左节点搜索
            return searchBst(root.left, val);
        } else if (root.val < val) {
            //根节点 小于 搜索值 直接去 做右节点搜索
            return searchBst(root.right, val);
        }
        return root;
    }
}
