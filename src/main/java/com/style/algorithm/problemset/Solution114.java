package com.style.algorithm.problemset;

import com.style.algorithm.model.TreeNode;

/**
 * 114. 二叉树展开为链表
 *
 * @author leon
 * @date 2022-01-16 21:32:22
 */
public class Solution114 {
    //给你二叉树的根结点 root ，请你将它展开为一个单链表：
    //
    //展开后的单链表应该同样使用 TreeNode ，其中 right 子指针指向链表中下一个结点，而左子指针始终为 null 。
    //展开后的单链表应该与二叉树 先序遍历 顺序相同。
    //
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/flatten-binary-tree-to-linked-list
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    public static void flatten(TreeNode root) {
        if (null == root) {
            return;
        }
        flatten(root.left);
        flatten(root.right);
        //记录左右节点
        TreeNode left = root.left;
        TreeNode right = root.right;

        root.left = null;
        root.right = left;

        TreeNode p = root;
        while (p.right != null) {
            p = p.right;
        }
        p.right = right;

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(5);
        root.left = left;
        root.right = right;

        TreeNode three = new TreeNode(3);
        TreeNode four = new TreeNode(4);
        TreeNode six = new TreeNode(6);
        left.left = three;
        left.right = four;
        right.right = six;

        flatten(root);
    }
}
