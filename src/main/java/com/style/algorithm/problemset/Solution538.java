package com.style.algorithm.problemset;

import com.style.algorithm.model.TreeNode;

/**
 * 538. 把二叉搜索树转换为累加树
 *
 * @author leon
 * @date 2022-01-21 21:39:01
 */
public class Solution538 {
    //给出二叉 搜索 树的根节点，该树的节点值各不相同，请你将其转换为累加树（Greater Sum Tree），使每个节点 node 的新值等于原树中大于或等于 node.val 的值之和。
    //
    //提醒一下，二叉搜索树满足下列约束条件：
    //
    //节点的左子树仅包含键 小于 节点键的节点。
    //节点的右子树仅包含键 大于 节点键的节点。
    //左右子树也必须是二叉搜索树。
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/convert-bst-to-greater-tree
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    private int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        traverse(root);
        return root;
    }

    private void traverse(TreeNode root) {
        if(null == root){
            return;
        }
        traverse(root.right);
        //维护累加和
        sum += root.val;
        //赋值操作
        root.val = sum;
        traverse(root.left);
    }
}
