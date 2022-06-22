package com.style.algorithm.problemset;

import java.util.LinkedList;
import java.util.List;

/**
 * 886. 可能的二分法
 *
 * @author leon
 * @date 2022-01-26 22:03:20
 */
@SuppressWarnings("all")
public class Solution886 {
    //给定一组N人（编号为1, 2, ..., N），我们想把每个人分进任意大小的两组。
    //
    //每个人都可能不喜欢其他人，那么他们不应该属于同一组。
    //
    //形式上，如果 dislikes[i] = [a, b]，表示不允许将编号为 a 和 b 的人归入同一组。
    //
    //当可以用这种方法将所有人分进两组时，返回 true；否则返回 false。
    //
    //
    //
    //示例 1：
    //
    //输入：N = 4, dislikes = [[1,2],[1,3],[2,4]]
    //输出：true
    //解释：group1 [1,4], group2 [2,3]
    //示例 2：
    //
    //输入：N = 3, dislikes = [[1,2],[1,3],[2,3]]
    //输出：false
    //示例 3：
    //
    //输入：N = 5, dislikes = [[1,2],[2,3],[3,4],[4,5],[1,5]]
    //输出：false
    //
    //
    //提示：
    //
    //1 <= N <= 2000
    //0 <= dislikes.length <= 10000
    //dislikes[i].length == 2
    //1 <= dislikes[i][j] <= N
    //dislikes[i][0] < dislikes[i][1]
    //对于 dislikes[i] == dislikes[j] 不存在 i != j
    //
    //来源：力扣（LeetCode）
    //链接：https://leetcode-cn.com/problems/possible-bipartition
    //著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。

    //二分图 判定
    //增加 visited 访问标记数组 color颜色标记数组  ok 是否为二分图
    //构造图 互为不喜欢 即为双向图  也就是无向图
    //递归 没有被访问 进行递归
    // 不是二分图 应该return  增加访问标记
    // 判断 s和相邻节点 相邻节点是否被访问 被访问则进行颜色判断 更新OK标记 没有被访问 进行上色 继续递归 相邻的节点

    private static boolean[] visited, color;
    private static boolean ok = true;

    public static boolean possibleBipartition(int n, int[][] dislikes) {
        List<Integer>[] graph = build(n, dislikes);
        visited = new boolean[n + 1];
        color = new boolean[n + 1];
        for (int i = 1; i <= n; i++) {
            if (!visited[i]) {
                //没有访问过 则进行递归
                traverse(graph, i);
            }
        }
        return ok;
    }

    private static void traverse(List<Integer>[] graph, int s) {
        if (!ok) {
            //不是二分图 直接返回
            return;
        }
        //访问标记
        visited[s] = true;
        for (int g : graph[s]) {
            if (!visited[g]) {
                //相邻节点没有被访问 进行上色
                color[g] = !color[s];
                //进行递归 子节点
                traverse(graph, g);
            } else {
                //已经被访问过 则看颜色是否 相同
                if (color[s] == color[g]) {
                    ok = false;
                }
            }
        }
    }

    private static List<Integer>[] build(int n, int[][] dislikes) {
        List<Integer>[] graph = new LinkedList[n + 1];
        for (int i = 1; i <= n; i++) {
            graph[i] = new LinkedList<>();
        }

        for (int[] dislike : dislikes) {
            int v = dislike[1];
            int w = dislike[0];
            graph[v].add(w);
            graph[w].add(v);
        }
        return graph;
    }

    public static void main(String[] args) {
        int [][] graph = new int[3][2];
        graph[0] = new int[]{1,2};
        graph[1] = new int[]{1,3};
        graph[2] = new int[]{2,4};
        boolean b = possibleBipartition(4, graph);
        System.out.println(b);
    }

}
