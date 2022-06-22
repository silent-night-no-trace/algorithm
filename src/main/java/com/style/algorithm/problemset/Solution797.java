package com.style.algorithm.problemset;

import java.util.LinkedList;
import java.util.List;

/**
 * 797. 所有可能的路径
 *
 * @author leon
 * @date 2022-01-25 21:43:20
 */
public class Solution797 {
    //给你一个有n个节点的 有向无环图（DAG），请你找出所有从节点 0到节点 n-1的路径并输出（不要求按特定顺序）
    //
    //graph[i]是一个从节点 i 可以访问的所有节点的列表（即从节点 i 到节点graph[i][j]存在一条有向边）。
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/all-paths-from-source-to-target
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
    // 究极递归
    //
    // traverse(graph,0,path)
    //1.添加节点 到path
    //2. 判断是否到达重点 到达终点 添加节点到结果集合 同时 移除 path
    //3.递归 该节点的每个子节点
    //4.移除path

    private final List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        LinkedList<Integer> path = new LinkedList<>();
        traverse(graph, 0, path);
        return res;
    }

    private void traverse(int[][] graph, int s, LinkedList<Integer> path) {
        //记录节点
        path.addLast(s);
        //判断是否到达重点
        int n = graph.length;
        if (s == n - 1) {
            //到达终点
            res.add(new LinkedList<>(path));
            path.removeLast();
            return;
        }
        //递归s相邻的每个节点每个节点
        for (int v : graph[s]) {
            traverse(graph, v, path);
        }
        //移除节点
        path.removeLast();
    }
}
