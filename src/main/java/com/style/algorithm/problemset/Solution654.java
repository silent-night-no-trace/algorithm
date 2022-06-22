package com.style.algorithm.problemset;

import com.style.algorithm.model.TreeNode;

/**
 * 654. 最大二叉树
 *
 * @author leon
 * @date 2022-01-17 22:36:22
 */
public class Solution654 {
    //给定一个不含重复元素的整数数组 nums 。一个以此数组直接递归构建的 最大二叉树 定义如下：
    //
    //二叉树的根是数组 nums 中的最大元素。
    //左子树是通过数组中 最大值左边部分 递归构造出的最大二叉树。
    //右子树是通过数组中 最大值右边部分 递归构造出的最大二叉树。
    //返回有给定数组 nums 构建的 最大二叉树 。
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/maximum-binary-tree
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    public static TreeNode constructMaximumBinaryTree(int[] nums) {
        if (null == nums) {
            return null;
        }
        int length = nums.length;
        if (length <= 0) {
            return null;
        }
        return build(nums, 0, length - 1);
    }

    private static TreeNode build(int[] nums, int lo, int hi) {
        //base case
        if (lo > hi) {
            return null;
        }
        //获取最大值 以及对应的索引
        int maxVal = Integer.MIN_VALUE, index = -1;

        for (int i = lo; i <= hi; i++) {
            if (nums[i] > maxVal) {
                maxVal = nums[i];
                index = i;
            }
        }
        //构建根节点
        TreeNode root = new TreeNode(maxVal);
        //构造左右子树 最大值左边即为左子树节点  最大值右边即为右子树节点
        root.left = build(nums, lo, index - 1);
        root.right = build(nums, index + 1, hi);
        return root;
    }

    public static void main(String[] args) {
        int [] nums = {3,2,1,6,0,5};
        TreeNode treeNode = constructMaximumBinaryTree(nums);
        System.out.println(treeNode);
    }
}
