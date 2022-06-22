package com.style.algorithm.problemset;

import com.style.algorithm.model.TreeNode;

import java.util.LinkedList;
import java.util.List;

/**
 * 95. 不同的二叉搜索树 II
 *
 * @author leon
 * @date 2022-01-25 20:50:40
 */
public class Solution95 {
    //给你一个整数 n ，请你生成并返回所有由 n 个节点组成且节点值从 1 到 n 互不相同的不同 二叉搜索树 。
    // 可以按 任意顺序 返回答案。

    public List<TreeNode> generateTrees(int n) {
        if (n <= 0) {
            return new LinkedList<>();
        }
        return build(1, n);
    }

    private List<TreeNode> build(int lo, int hi) {
        LinkedList<TreeNode> res = new LinkedList<>();
        if (lo > hi) {
            res.add(null);
            return res;
        }
        for (int i = lo; i <= hi; i++) {
            //递归 构造左右子树
            //以i为根节点构造左右子树
            List<TreeNode> lefts = build(lo, i - 1);
            List<TreeNode> rights = build(i + 1, hi);
            for (TreeNode left : lefts) {
                for (TreeNode right : rights) {
                    //构造i为根节点的所有左右子树的组合。
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    res.add(root);
                }
            }
        }

        return res;
    }

}
