package com.style.algorithm.problemset;

import com.style.algorithm.model.TreeNode;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/**
 * 652. 寻找重复的子树
 *
 * @author leon
 * @date 2022-01-18 17:50:05
 */
public class Solution652 {
    //给定一棵二叉树，返回所有重复的子树。对于同一类的重复子树，你只需要返回其中任意一棵的根结点即可。
    //
    //两棵树重复是指它们具有相同的结构以及相同的结点值。
    //
    //示例 1：
    //
    //        1
    //       / \
    //      2   3
    //     /   / \
    //    4   2   4
    //       /
    //      4
    //下面是两个重复的子树：
    //
    //      2
    //     /
    //    4
    //和
    //
    //    4
    //
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/find-duplicate-subtrees
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    /**
     * 定义结果
     */
    private LinkedList<TreeNode> res = new LinkedList<>();
    /**
     * 存储每个子树出现的次数
     */
    private Map<String, Integer> map = new HashMap<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        traverse(root);
        return res;
    }

    private String traverse(TreeNode root) {
        if (root == null) {
            return "#";
        }
        //后序遍历
        String left = traverse(root.left);
        String right = traverse(root.right);
        //子树
        String subTree = left + "," + right + "," + root.val;
        Integer count = map.getOrDefault(subTree, 0);
        //已经存在1次 加入到结果
        if (count == 1) {
            res.add(root);
        }
        map.put(subTree, count + 1);
        return subTree;
    }
}
