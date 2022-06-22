package com.style.algorithm.problemset;

import java.util.Date;

/**
 * 96. 不同的二叉搜索树
 *
 * @author leon
 * @date 2022-01-25 20:20:50
 */
public class Solution96 {
    //给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？
    // 返回满足题意的二叉搜索树的种数。

    private static int[][] memo;

    public static int numTrees(int n) {
        memo = new int[n + 1][n + 1];
        return count(1, n);
    }

    private static int count(int lo, int hi) {
        if (lo > hi) {
            return 1;
        }
        //首先先从备忘录中获取 值有效 直接返回
        if (memo[lo][hi] != 0) {
            return memo[lo][hi];
        }

        int res = 0;

        for (int i = lo; i <= hi; i++) {
            //以i为根的树
            //左子树
            int left = count(lo, i - 1);
            int right = count(i + 1, hi);
            //// 左右子树的组合数乘积是 BST 的总数
            res += left + right;
        }
        //存入备忘录
        memo[lo][hi] = res;
        return res;
    }

    public static void main(String[] args) {
        System.out.println(System.currentTimeMillis());
        System.out.println(numTrees(18));
        System.out.println(System.currentTimeMillis());
    }
}
