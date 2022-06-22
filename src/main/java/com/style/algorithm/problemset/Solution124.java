package com.style.algorithm.problemset;


/**
 * @author leon
 * @date 2021-11-22 15:06:40
 */
public class Solution124 {

    /**
     * 为0 用例通不过
     */
    private static int result = Integer.MIN_VALUE;

    public static int maxPathSum(TreeNode root) {
        maxGain(root);
        return result;
    }

    public static int maxGain(TreeNode root) {
        if (null == root) {
            return 0;
        }
        int left = Math.max(0, maxGain(root.left));
        int right = Math.max(0, maxGain(root.right));
        int newMax = left + right + root.val;
        result = Math.max(result, newMax);
        return Math.max(left, right) + root.val;
    }

    public static void main(String[] args) {
        TreeNode left = new TreeNode(3);
        TreeNode right = new TreeNode(5);
        TreeNode treeNode = new TreeNode(1,left,right);

        int max = maxPathSum(treeNode);
        System.out.println(max);
    }

    static class TreeNode {
        private final Integer val;
        private final TreeNode left;
        private final TreeNode right;

        public TreeNode(Integer val) {
            this.val = val;
            this.left = null;
            this.right = null;
        }

        public TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
