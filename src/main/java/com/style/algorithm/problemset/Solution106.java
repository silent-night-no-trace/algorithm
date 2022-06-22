package com.style.algorithm.problemset;

import com.style.algorithm.model.TreeNode;

/**
 * 106. 从中序与后序遍历序列构造二叉树¬
 *
 * @author leon
 * @date 2022-01-18 14:32:00
 */
@SuppressWarnings("all")
public class Solution106 {
    //根据一棵树的中序遍历与后序遍历构造二叉树。
    //
    //注意:
    //你可以假设树中没有重复的元素。
    //
    //例如，给出
    //
    //中序遍历 inorder =[9,3,15,20,7]
    //后序遍历 postorder = [9,15,7,20,3]
    //返回如下的二叉树：
    //
    //    3
    //   / \
    //  9  20
    //    /  \
    //   15   7
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


    public static TreeNode buildTree(int[] inorder, int[] postorder) {
        return build(inorder, 0, inorder.length - 1, postorder, 0, postorder.length - 1);
    }

    private static TreeNode build(int[] inorder, int inStart, int inEnd, int[] postorder, int postStart, int postEnd) {
        if (inStart > inEnd) {
            return null;
        }
        //根节点
        int rootVal = postorder[postEnd];
        //记录根节点在 中序遍历中索引位
        int index = -1;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == rootVal) {
                index = i;
                break;
            }
        }
        //左子树数量
        int leftSize = index - inStart;
        //根节点
        TreeNode root = new TreeNode(rootVal);
        root.left = build(inorder, inStart, index - 1, postorder, postStart, postStart + leftSize - 1);
        //后序遍历最后一个数据为根节点 后序遍历后注意
        //中后 postStart postStart+leftSize-1 postStart+leftSize postEnd-1
        root.right = build(inorder, index + 1, inEnd, postorder, postStart + leftSize, postEnd - 1);

        return root;
    }

    public static void main(String[] args) {
        //中序遍历 inorder =[9,3,15,20,7]
        //后序遍历 postorder = [9,15,7,20,3]
        int[] inorder = {9, 3, 15, 20, 7};
        int[] postorder = {9, 15, 7, 20, 3};

        TreeNode treeNode = buildTree(inorder, postorder);
        System.out.println("treeNode: " + treeNode);
    }
}
