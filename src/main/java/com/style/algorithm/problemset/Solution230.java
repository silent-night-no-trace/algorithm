package com.style.algorithm.problemset;

import com.style.algorithm.model.TreeNode;

/**
 * 230. 二叉搜索树中第K小的元素
 *
 * @author leon
 * @date 2022-01-21 21:28:09
 */
public class Solution230 {
    //给定一个二叉搜索树的根节点 root ，和一个整数 k ，请你设计一个算法查找其中第 k 个最小元素（从 1 开始计数）。

    //如果按照我们刚才说的⽅法，利⽤「BST 中序遍历就是升序排序结果」这个性质，每次寻找第 k ⼩的元素都 要中序遍历⼀次，最坏的时间复杂度是 O(N)，N 是 BST 的节点个数。 要知道 BST 性质是⾮常⽜逼的，像红⿊树这种改良的⾃平衡 BST，增删查改都是 O(logN) 的复杂度，让你 算⼀个第 k ⼩元素，时间复杂度竟然要 O(N)，有点低效了。 所以说，计算第 k ⼩元素，最好的算法肯定也是对数级别的复杂度，不过这个依赖于 BST 节点记录的信息有 多少。 我们想⼀下 BST 的操作为什么这么⾼效？就拿搜索某⼀个元素来说，BST 能够在对数时间找到该元素的根本 原因还是在 BST 的定义⾥，左⼦树⼩右⼦树⼤嘛，所以每个节点都可以通过对⽐⾃身的值判断去左⼦树还是 右⼦树搜索⽬标值，从⽽避免了全树遍历，达到对数级复杂度。 那么回到这个问题，想找到第 k ⼩的元素，或者说找到排名为 k 的元素，如果想达到对数级复杂度，关键也 在于每个节点得知道他⾃⼰排第⼏。 ⽐如说你让我查找排名为 k 的元素，当前节点知道⾃⼰排名第 m，那么我可以⽐较 m 和 k 的⼤⼩： 1、如果 m == k，显然就是找到了第 k 个元素，返回当前节点就⾏了。 2、如果 k < m，那说明排名第 k 的元素在左⼦树，所以可以去左⼦树搜索第 k 个元素。 3、如果 k > m，那说明排名第 k 的元素在右⼦树，所以可以去右⼦树搜索第 k - m - 1 个元素。 这样就可以将时间复杂度降到 O(logN) 了。 那么，如何让每⼀个节点知道⾃⼰的排名呢？ 这就是我们之前说的，需要在⼆叉树节点中维护额外信息。每个节点需要记录，以⾃⼰为根的这棵⼆叉树有 多少个节点。 也就是说，我们 TreeNode 中的字段应该如下：
    //class TreeNode {
    //int val;
    // 以该节点为根的树的节点总数
    //int size;
    // TreeNode left;
    // TreeNode right;
    //}
    //有了 size 字段，外加 BST 节点左⼩右⼤的性质，对于每个节点 node 就可以通过 node.left 推导出 node
    //的排名，从⽽做到我们刚才说到的对数级算法。 当然，size 字段需要在增删元素的时候需要被正确维护，
    // ⼒扣提供的 TreeNode 是没有 size 这个字段 的，所以我们这道题就只能利⽤ BST 中序遍历的特性实现了

    /**
     * 结果
     */
    private int res = 0;
    /**
     * 当前索引位置
     */
    private int index = 0;

    public int kthSmallest(TreeNode root, int k) {
        traverse(root, k);
        return res;
    }

    private void traverse(TreeNode root, int k) {
        //base case
        if (null == root) {
            return;
        }
        traverse(root.left, k);
        //中序遍历位置
        index++;
        if (index == k) {
            res = root.val;
            return;
        }
        traverse(root.right, k);
    }
}
