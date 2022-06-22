package com.style.algorithm.problemset;

import com.style.algorithm.model.TreeNode;

/**
 * 450. 删除二叉搜索树中的节点
 *
 * @author leon
 * @date 2022-01-22 12:14:49
 */
@SuppressWarnings("all")
public class Solution450 {
    //给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的 key 对应的节点，并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
    //
    //一般来说，删除节点可分为两个步骤：
    //
    //首先找到需要删除的节点；
    //如果找到了，删除它。
    // 
    //
    //示例 1:
    //
    //
    //
    //输入：root = [5,3,6,2,4,null,7], key = 3
    //输出：[5,4,6,2,null,null,7]
    //解释：给定需要删除的节点值是 3，所以我们首先找到 3 这个节点，然后删除它。
    //一个正确的答案是 [5,4,6,2,null,null,7], 如下图所示。
    //另一个正确答案是 [5,2,6,null,4,null,7]。
    //
    //
    //示例 2:
    //
    //输入: root = [5,3,6,2,4,null,7], key = 0
    //输出: [5,3,6,2,4,null,7]
    //解释: 二叉树不包含值为 0 的节点
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/delete-node-in-a-bst
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (root.val == key) {
            //找了 准备删除
            if (null == root.left) {
                return root.right;
            }
            if (null == root.right) {
                return root.left;
            }
            //第三种 左子树右子树 都不为空的情况
            //找到右子树最小节点
            TreeNode min = getMin(root.right);
            //删掉右子树最小节点
            root.right = deleteNode(root.right, min.val);
            min.left = root.left;
            min.right = root.right;
            root = min;
        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else {
            root.right = deleteNode(root.right, key);
        }

        return root;
    }

    private TreeNode getMin(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }
}
