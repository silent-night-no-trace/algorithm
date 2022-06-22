package com.style.algorithm.problemset;

import com.style.algorithm.model.TreeNode;

/**
 * 105. 从前序与中序遍历序列构造二叉树
 *
 * @author leon
 * @date 2022-01-18 09:57:12
 */
@SuppressWarnings("all")
public class Solution105 {
    //给定一棵树的前序遍历 preorder 与中序遍历  inorder。请构造二叉树并返回其根节点。
    //Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
    //Output: [3,9,20,null,null,15,7]
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。


    public static TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private static TreeNode build(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        if (preStart > preEnd) {
            return null;
        }
        //root节点
        int rootVal = preorder[preStart];
        //root 在中序遍历中对应的索引
        int index = -1;
        for (int i = inStart; i <= inEnd; i++) {
            if (inorder[i] == rootVal) {
                index = i;
                break;
            }
        }
        //左子树的数量
        int leftSize = index - inStart;
        //根节点
        TreeNode root = new TreeNode(rootVal);
        //前序遍历 前注意
        //前中  preStart+1 preStart+leftSize preStart+leftSize+1 preEnd
        root.left = build(preorder, preStart + 1, preStart + leftSize, inorder, inStart, index - 1);
        root.right = build(preorder, preStart + leftSize + 1, preEnd, inorder, index + 1, inEnd);
        return root;
    }

    public static void main(String[] args) {
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};
        TreeNode treeNode = buildTree(preorder, inorder);
        System.out.println(treeNode.toString());
    }

}
