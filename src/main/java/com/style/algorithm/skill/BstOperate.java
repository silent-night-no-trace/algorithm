package com.style.algorithm.skill;

import com.style.algorithm.model.TreeNode;

/**
 * bst 操作
 *
 * @author leon
 * @date 2022-01-23 22:18:48
 */
@SuppressWarnings("all")
public class BstOperate {

    /**
     * 判断Bst是否有效
     *
     * @param root root
     * @return boolean
     */
    public boolean isValidBst(TreeNode root) {
        return isValidBst(root, null, null);
    }

    private boolean isValidBst(TreeNode root, TreeNode min, TreeNode max) {
        if (null == root) {
            return true;
        }
        if (null != min && root.val <= min.val) {
            return false;
        }
        if (null != max && root.val >= max.val) {
            return false;
        }
        return isValidBst(root.left, min, root)
                && isValidBst(root.right, root, max);
    }

    /**
     * 搜索BST
     *
     * @param root root
     * @param val  val
     * @return TreeNode
     */
    public TreeNode searchBst(TreeNode root, int val) {
        if (null == root) {
            return null;
        }
        if (root.val > val) {
            return searchBst(root.left, val);
        } else if (root.val < val) {
            return searchBst(root.right, val);
        }
        return root;
    }

    /**
     * Bst插入 创建新的节点
     *
     * @param root root
     * @param val  val
     * @return TreeNode
     */
    public TreeNode insertIntoBst(TreeNode root, int val) {
        if (null == root) {
            return new TreeNode(val);
        }
        if (root.val > val) {
            root.left = insertIntoBst(root.left, val);
        } else if (root.val < val) {
            root.right = insertIntoBst(root.right, val);
        }
        return root;
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (null == root) {
            return null;
        }
        // 1.先找到 2 再删除
        if (root.val == key) {
            //找到要删除的key
            //左节点 或者 右节点 为空
            if (root.left == null) {
                return root.right;
            }
            if (root.right == null) {
                return root.left;
            }
            //左节点 右节点 都不为空
            //找到右节点最小值
            TreeNode min = getMin(root.right);
            //删除右节点
            root.right = deleteNode(root.right, min.val);
            //将root的左右节点赋值给 min
            min.left = root.left;
            min.right = root.right;
            //将最小节点 赋值给root节点
            root = min;
        } else if (root.val > key) {
            root.left = deleteNode(root.left, key);
        } else if (root.val < key) {
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
