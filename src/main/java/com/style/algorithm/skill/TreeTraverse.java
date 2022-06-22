package com.style.algorithm.skill;

import com.style.algorithm.model.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 树遍历
 *
 * @author leon
 * @date 2022-01-10 21:45:18
 */
public class TreeTraverse {

    private static final LinkedList<Integer> res = new LinkedList<>();

    /**
     * 前顺序遍历
     * 回溯算法核⼼思路
     *
     * @param root root
     * @return List<Integer>
     */
    public static List<Integer> preOrder(TreeNode root) {
        traverse(root);
        return res;
    }

    /**
     * 二叉树遍历
     *
     * @param root treeNode
     */
    private static void traverse(TreeNode root) {
        if (null == root) {
            return;
        }
        res.addLast(root.val);
        traverse(root.left);
        traverse(root.right);
    }

    /**
     * 前顺序遍历
     * 动态规划核⼼思路
     *
     * @param root root
     * @return List<Integer>
     */
    public static List<Integer> preOrder2(TreeNode root) {
        LinkedList<Integer> res = new LinkedList<>();
        if (null == root) {
            return res;
        }
        // 前序遍历的结果，root.val 在第⼀个
        res.add(root.val);
        // 后⾯接着左⼦树的前序遍历结果
        res.addAll(preOrder2(root.left));
        // 最后接着右⼦树的前序遍历结果
        res.addAll(preOrder2(root.right));
        return res;
    }

    public static void main(String[] args) {
        TreeNode left = new TreeNode(1);
        TreeNode root = new TreeNode(2);
        TreeNode right = new TreeNode(3);
        root.left = left;
        root.right = right;
        List<Integer> res = preOrder(root);
        System.out.println("res: " + Arrays.toString(res.toArray()));
        List<Integer> res1 = preOrder2(root);
        System.out.println("res1: " + Arrays.toString(res1.toArray()));
    }

}
