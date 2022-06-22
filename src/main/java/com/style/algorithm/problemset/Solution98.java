package com.style.algorithm.problemset;

import com.style.algorithm.model.TreeNode;

/**
 * 98. 验证二叉搜索树
 *
 * @author leon
 * @date 2022-01-21 22:56:06
 */
@SuppressWarnings("all")
public class Solution98 {
    //给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
    //
    //有效 二叉搜索树定义如下：
    //
    //节点的左子树只包含 小于 当前节点的数。
    //节点的右子树只包含 大于 当前节点的数。
    //所有左子树和右子树自身必须也是二叉搜索树。
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/validate-binary-search-tree
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    public boolean isValidBST(TreeNode root) {
        return isValidBST(root, null, null);
    }

    private boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {
        if (null == root) {
            return true;
        }
        if (min != null && root.val <= min.val) {
            return false;
        }
        if (max != null && root.val >= max.val) {
            return false;
        }
        return isValidBST(root.left, min, root)
                && isValidBST(root.right, root, max);
    }
}
