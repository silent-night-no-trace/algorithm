package com.style.algorithm.problemset;

import java.util.LinkedList;

/**
 * 785. 判断二分图
 *
 * @author leon
 * @date 2022-01-26 22:00:49
 */
@SuppressWarnings("all")
public class Solution785 {
    //存在一个 无向图 ，图中有 n 个节点。其中每个节点都有一个介于 0 到 n - 1 之间的唯一编号。给你一个二维数组 graph ，其中 graph[u] 是一个节点数组，由节点 u 的邻接节点组成。形式上，对于graph[u] 中的每个 v ，都存在一条位于节点 u 和节点 v 之间的无向边。该无向图同时具有以下属性：
    //不存在自环（graph[u] 不包含 u）。
    //不存在平行边（graph[u] 不包含重复值）。
    //如果 v 在 graph[u] 内，那么 u 也应该在 graph[v] 内（该图是无向图）
    //这个图可能不是连通图，也就是说两个节点 u 和 v 之间可能不存在一条连通彼此的路径。
    //二分图 定义：如果能将一个图的节点集合分割成两个独立的子集 A 和 B ，并使图中的每一条边的两个节点一个来自 A 集合，一个来自 B 集合，就将这个图称为 二分图 。
    //
    //如果图是二分图，返回 true ；否则，返回 false 。
    //
    //
    //
    //示例 1：
    //
    //
    //输入：graph = [[1,2,3],[0,2],[0,1,3],[0,2]]
    //输出：false
    //解释：不能将节点分割成两个独立的子集，以使每条边都连通一个子集中的一个节点与另一个子集中的一个节点。
    //示例 2：
    //
    //
    //输入：graph = [[1,3],[0,2],[1,3],[0,2]]
    //输出：true
    //解释：可以将节点分成两组: {0, 2} 和 {1, 3} 。
    //
    //提示：
    //
    //graph.length == n
    //1 <= n <= 100
    //0 <= graph[u].length < n
    //0 <= graph[u][i] <= n - 1
    //graph[u] 不会包含 u
    //graph[u] 的所有值 互不相同
    //如果 graph[u] 包含 v，那么 graph[v] 也会包含 u
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/is-graph-bipartite
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    //OK 标记是否 为二分图 增加颜色标记数组 以及访问数组
    //初始化数组 循环graph长度遍历 该索引下节点 没有被访问 递归 traverse(graph,i)
    //!ok 退出增加访问标记
    //循环i的相邻节点
    //判断相邻节点是否被访问过 1.没有被访问过 进行上色 与i节点相反的颜色  2. 被访问过 判断 i的颜色是否与相邻节点颜色相同 相同 则不是二分图

    /**
     * 标记是否符合二分图
     */
    private static boolean ok = true;
    /**
     * 标记是否被访问过 已经颜色标记
     */
    private static boolean[] visited, color;

    public static boolean isBipartite(int[][] graph) {
        int n = graph.length;
        visited = new boolean[n];
        color = new boolean[n];
        for (int v = 0; v < n; v++) {
            if (!visited[v]) {
                //没有访问过 才进行遍历
                traverse(graph, v);
            }

        }
        return ok;
    }

    private static void traverse(int[][] graph, int v) {
        if (!ok) {
            return;
        }
        //访问标记
        visited[v] = true;
        //获取V的相邻节点
        for (int g : graph[v]) {
            if (!visited[g]) {
                //相邻节点 g 应该标记为 v的相反色
                color[g] = !color[v];
                //继续遍历
                traverse(graph, g);
            } else {
                if (color[g] == color[v]) {
                    //相邻节点颜色相同 则不是二分图
                    ok = false;
                }
            }
        }
    }

    public void bfs(int[][] graph, int v) {
        LinkedList<Integer> queue = new LinkedList<>();
        //访问标记为true
        visited[v] = true;
        queue.offer(v);
        while (!queue.isEmpty() && ok) {
            Integer poll = queue.poll();
            for (int g : graph[poll]) {
                if (!visited[g]) {
                    //给相邻节点上色
                    color[g] = !color[poll];
                    //增加访问标记
                    visited[g] = true;
                    queue.offer(g);
                } else {
                    if (color[g] == color[poll]) {
                        //临节点颜色g和poll相同 则不是二分图
                        ok = false;
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        //[[1,3],[0,2],[1,3],[0,2]]
        int[][] graph = new int[4][2];
        graph[0] = new int []{1,3};
        graph[1] = new int []{0,2};
        graph[2] = new int []{1,3};
        graph[3] = new int []{0,2};
        boolean bipartite = isBipartite(graph);
        System.out.println(bipartite);
    }
}
