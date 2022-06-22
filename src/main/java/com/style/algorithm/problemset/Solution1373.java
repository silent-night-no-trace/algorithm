package com.style.algorithm.problemset;

import com.style.algorithm.model.TreeNode;

/**
 * 1373. 二叉搜索子树的最大键值和
 *
 * @author leon
 * @date 2022-01-20 21:33:51
 */
public class Solution1373 {
    //BST 是⼀种特殊的⼆叉树，你只要记住它的两个主要特点： 1、左⼩右⼤，即每个节点的左⼦树都⽐当前节点的值⼩，右⼦树都⽐当前节点的值⼤。 2、中序遍历结果是有序的。

    //给你一棵以root为根的二叉树，请你返回 任意二叉搜索子树的最大键值和。
    //
    //叉搜索树的定义如下：
    //
    //任意节点的左子树中的键值都小于此节点的键值。
    //任意节点的右子树中的键值都 大于此节点的键值。
    //任意节点的左子树和右子树都是二叉搜索树。
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/maximum-sum-bst-in-binary-tree
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    private static int maxSum = 0;

    public static int maxSumBst(TreeNode root) {
        traverse(root);
        return maxSum;
    }

    private static int[] traverse(TreeNode root) {
        //base case
        if (null == root) {
            return new int[]{1, Integer.MAX_VALUE, Integer.MIN_VALUE, 0};
        }
        //左右子树
        int[] left = traverse(root.left);
        int[] right = traverse(root.right);
        //构造4位长度数组 第一个为是否BS
        //后序遍历位置
        //第一个位标志为是否BST标志 第二位 最小值 第三位 最大值 第四位 根节点下树的和
        int[] res = new int[4];
        if (left[0] == 1 && right[0] == 1 && root.val > left[2] && root.val < right[1]) {
            res[0] = 1;
            //以root为根 的这个棵BST的最小值
            res[1] = Math.min(left[1], root.val);
            //以root为根 的这个棵BST 最大值
            res[2] = Math.max(right[2], root.val);
            //节点和
            res[3] = left[3] + right[3] + root.val;
            //更新最大值
            maxSum = Math.max(maxSum, res[3]);
        } else {
            res[0] = 0;
        }

        return res;
    }

    public static void main(String[] args) {
        //输入：root = [4,3,null,1,2]
        TreeNode root = new TreeNode(4);
        TreeNode three = new TreeNode(3);
        TreeNode one = new TreeNode(1);
        TreeNode two = new TreeNode(2);
        root.left = three;
        three.left = one;
        three.right = two;
        System.out.println(maxSumBst(root));

    }

}
